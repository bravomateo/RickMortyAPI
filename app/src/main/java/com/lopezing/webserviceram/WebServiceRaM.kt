package com.lopezing.webserviceram

import android.app.Application
import androidx.room.Room
import com.lopezing.webserviceram.local.PersonDatabase

class WebServiceRaM:Application() {

    companion object{
        lateinit var database: PersonDatabase
    }
    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(
            this,
            PersonDatabase::class.java,
            "person_ram"
        ).build()
    }
}