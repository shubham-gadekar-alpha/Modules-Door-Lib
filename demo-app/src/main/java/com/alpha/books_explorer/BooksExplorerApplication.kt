package com.alpha.books_explorer

import android.app.Application
import com.alpha.data.DataDoor
import com.alpha.modulesDoor.Door
import com.alpha.modulesDoor.DoorEntry
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BooksExplorerApplication : Application() {

    @Inject
    lateinit var door: Door

    @Inject
    lateinit var dataDoor: DataDoor

    @Inject
    lateinit var mainAppDoor: MainAppDoor

    private val doorList: List<DoorEntry>
        get() = listOf(
            dataDoor,
            mainAppDoor
        )

    override fun onCreate() {
        super.onCreate()
        door.init(doorList)
    }
}
