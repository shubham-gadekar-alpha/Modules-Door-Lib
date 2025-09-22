package com.alpha.data

import android.content.Context
import com.alpha.data.repository.BookRepository
import com.alpha.modulesDoor.DoorCommand
import com.alpha.modulesDoor.DoorEntry
import com.alpha.modulesDoor.messageTypes.EventType
import com.alpha.modulesDoor.messageTypes.MessageType
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@Singleton
class DataDoor @Inject internal constructor(
    private val bookRepository: BookRepository,
) : DoorEntry() {

    private val _bookByIdFlow = MutableSharedFlow<DoorCommand>()
    private val bookByIdFlow: SharedFlow<DoorCommand> = _bookByIdFlow

    private val _readingList = MutableSharedFlow<DoorCommand>()
    private val readingList: SharedFlow<DoorCommand> = _readingList

    private val _searchBooks = MutableSharedFlow<DoorCommand>()
    private val searchBooks: SharedFlow<DoorCommand> = _searchBooks

    private val _favBooks = MutableSharedFlow<DoorCommand>()
    private val favBooks: SharedFlow<DoorCommand> = _favBooks

    private val _isBookPresentInFavList = MutableSharedFlow<DoorCommand>()
    private val isBookPresentInFavList: SharedFlow<DoorCommand> = _isBookPresentInFavList

    private val _isBookPresentInReadingList = MutableSharedFlow<DoorCommand>()
    private val isBookPresentInReadingList: SharedFlow<DoorCommand> = _isBookPresentInReadingList

    override fun init() {}

    override val eventList: List<EventType>
        get() = listOf(
            EventType.PublishType("SubscribeBookById", this),
            EventType.PublishType("SubscribeReadingList", this),
            EventType.PublishType("SubscribeSearchResult", this),
            EventType.PublishType("SubscribeFavList", this),
            EventType.PublishType("SubscribeCheckFavBook", this),
            EventType.PublishType("SubscribeCheckReadingListBook", this),
        )

    override val messageList: List<MessageType>
        get() = listOf(
            MessageType.ReceiveType("GetBookById", this),
            MessageType.ReceiveType("GetReadingList", this),
            MessageType.ReceiveType("GetFavList", this),
            MessageType.ReceiveType("GetSearchResult", this),
            MessageType.ReceiveType("GetIfBookIsFav", this),
            MessageType.ReceiveType("GetIfBookIsInReadingList", this),
            MessageType.ReceiveType("AddBookIntoFavList", this),
            MessageType.ReceiveType("RemoveBookFromFavList", this),
            MessageType.ReceiveType("AddBookIntoReadingList", this),
            MessageType.ReceiveType("RemoveBookFromReadingList", this),

            MessageType.SendType("ReceivedBookByIdResponse", this),
            MessageType.SendType("ReceivedBookListResponse", this),
        )

    override fun onReceive(message: DoorCommand) {
        if (message.messageName == "GetBookById") {
            CoroutineScope(Dispatchers.IO).launch {
                val book = bookRepository.getBookById(message.payload?.get("id")?.asString ?: "")
                val jsonObject: JsonObject = Gson().toJsonTree(book).asJsonObject
                messageSender.send(
                    DoorCommand(
                        messageName = "ReceivedBookByIdResponse",
                        payload = jsonObject,
                        doorName = this@DataDoor.name
                    )
                )
                _bookByIdFlow.emit(
                    DoorCommand(
                        messageName = "SubscribeBookById",
                        payload = jsonObject,
                        doorName = this@DataDoor.name
                    )
                )
            }
        } else if (message.messageName == "GetReadingList") {
            CoroutineScope(Dispatchers.IO).launch {
                val list = bookRepository.getReadingListBooks()
                if (list.isEmpty()) {
                    _readingList.emit(
                        DoorCommand(
                            messageName = "SubscribeReadingList",
                            payload = JsonObject().apply {
                                addProperty("error", "list is empty")
                            },
                            doorName = this@DataDoor.name
                        )
                    )
                } else {
                    val gson = Gson()
                    val jsonArray: JsonArray = gson.toJsonTree(list).asJsonArray
                    val jsonObject = JsonObject().apply {
                        add("books", jsonArray)
                    }
                    _readingList.emit(
                        DoorCommand(
                            messageName = "SubscribeReadingList",
                            payload = jsonObject,
                            doorName = this@DataDoor.name
                        )
                    )
                }
            }
        } else if (message.messageName == "GetFavList") {
            CoroutineScope(Dispatchers.IO).launch {
                val list = bookRepository.getFavListBooks()
                if (list.isEmpty()) {
                    _favBooks.emit(
                        DoorCommand(
                            messageName = "SubscribeFavList",
                            payload = JsonObject().apply {
                                addProperty("error", "list is empty")
                            },
                            doorName = this@DataDoor.name
                        )
                    )
                } else {
                    val gson = Gson()
                    val jsonArray: JsonArray = gson.toJsonTree(list).asJsonArray
                    val jsonObject = JsonObject().apply {
                        add("books", jsonArray)
                    }
                    _favBooks.emit(
                        DoorCommand(
                            messageName = "SubscribeFavList",
                            payload = jsonObject,
                            doorName = this@DataDoor.name
                        )
                    )
                }
            }
        } else if (message.messageName == "GetSearchResult") {
            CoroutineScope(Dispatchers.IO).launch {
                val books = bookRepository.getBooks(
                    query = message.payload?.get("query")?.asString ?: "",
                    start = message.payload?.get("startIndex")?.asInt ?: 0,
                    count = message.payload?.get("count")?.asInt ?: 20,
                )
                if (books.isEmpty()) {
                    _searchBooks.emit(
                        DoorCommand(
                            messageName = "SubscribeSearchResult",
                            payload = JsonObject().apply {
                                addProperty("error", "list is empty")
                            },
                            doorName = this@DataDoor.name
                        )
                    )
                } else {
                    val gson = Gson()
                    val jsonArray: JsonArray = gson.toJsonTree(books).asJsonArray
                    val jsonObject = JsonObject().apply {
                        add("books", jsonArray)
                    }

                    _searchBooks.emit(
                        DoorCommand(
                            messageName = "SubscribeSearchResult",
                            payload = jsonObject,
                            doorName = this@DataDoor.name
                        )
                    )
                }
            }
        } else if (message.messageName == "GetIfBookIsFav") {
            CoroutineScope(Dispatchers.IO).launch {
                val isFavBook = bookRepository.isBookPresentInFavList(
                    id = message.payload?.get("id")?.asString ?: ""
                )

                _isBookPresentInFavList.emit(
                    DoorCommand(
                        messageName = "SubscribeCheckFavBook",
                        payload = JsonObject().apply {
                            addProperty("isFav", isFavBook)
                        },
                        doorName = this@DataDoor.name
                    )
                )
            }
        } else if (message.messageName == "GetIfBookIsInReadingList") {
            CoroutineScope(Dispatchers.IO).launch {
                val isFavBook = bookRepository.isBookPresentInReadingList(
                    id = message.payload?.get("id")?.asString ?: ""
                )

                _isBookPresentInReadingList.emit(
                    DoorCommand(
                        messageName = "SubscribeCheckReadingListBook",
                        payload = JsonObject().apply {
                            addProperty("isInReadingList", isFavBook)
                        },
                        doorName = this@DataDoor.name
                    )
                )
            }
        } else if (message.messageName == "AddBookIntoFavList") {
            CoroutineScope(Dispatchers.IO).launch {
                val type = object : TypeToken<Book>() {}.type
                val book: Book = Gson().fromJson(message.payload, type)
                bookRepository.addIntoFavListBooks(book)
            }
        } else if (message.messageName == "RemoveBookFromFavList") {
            CoroutineScope(Dispatchers.IO).launch {
                val type = object : TypeToken<Book>() {}.type
                val book: Book = Gson().fromJson(message.payload, type)
                bookRepository.deleteFromFavListBooks(book)
            }
        } else if (message.messageName == "AddBookIntoReadingList") {
            CoroutineScope(Dispatchers.IO).launch {
                val type = object : TypeToken<Book>() {}.type
                val book: Book = Gson().fromJson(message.payload, type)
                bookRepository.addIntoReadingListBooks(book)
            }
        } else if (message.messageName == "RemoveBookFromReadingList") {
            CoroutineScope(Dispatchers.IO).launch {
                val type = object : TypeToken<Book>() {}.type
                val book: Book = Gson().fromJson(message.payload, type)
                bookRepository.deleteFromReadingListBooks(book)
            }
        }
    }

    override fun publish(message: DoorCommand): SharedFlow<DoorCommand> {
        return if (message.messageName == "SubscribeBookById") bookByIdFlow
        else if (message.messageName == "SubscribeReadingList") readingList
        else if (message.messageName == "SubscribeSearchResult") searchBooks
        else if (message.messageName == "SubscribeFavList") favBooks
        else if (message.messageName == "SubscribeCheckFavBook") isBookPresentInFavList
        else if (message.messageName == "SubscribeCheckReadingListBook") isBookPresentInReadingList
        else throw Exception("Message Not Subscribed")
    }

    override fun subscribe(
        subscription: SharedFlow<DoorCommand>,
        featureCommand: DoorCommand,
    ) {

    }
}
