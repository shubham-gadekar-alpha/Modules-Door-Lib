package com.alpha.modulesDoor

import com.alpha.modulesDoor.messageSender.MessageSender
import com.alpha.modulesDoor.messageTypes.EventType
import com.alpha.modulesDoor.messageTypes.MessageType
import kotlinx.coroutines.flow.SharedFlow

abstract class DoorEntry {

    lateinit var messageSender: MessageSender
        private set

    abstract val messageList: List<MessageType>

    abstract val eventList: List<EventType>

    abstract fun init()

    abstract fun onReceive(message: DoorCommand)

    abstract fun publish(message: DoorCommand): SharedFlow<DoorCommand>

    abstract fun subscribe(subscription: SharedFlow<DoorCommand>, featureCommand: DoorCommand)

    val name: String = javaClass.simpleName

    fun init(
        messageSender: MessageSender,
    ) {
        this.messageSender = messageSender
        init()
    }
}
