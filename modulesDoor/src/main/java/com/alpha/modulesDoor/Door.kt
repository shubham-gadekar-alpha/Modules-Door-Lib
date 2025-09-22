package com.alpha.modulesDoor

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Door @Inject constructor() {

    fun init(doorList: List<DoorEntry>) {
        DoorKernel().init(doorList)
    }
}
