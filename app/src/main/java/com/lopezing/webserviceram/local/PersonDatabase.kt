package com.lopezing.webserviceram.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalPerson::class], version = 1)
abstract class PersonDatabase:RoomDatabase() {
    abstract fun PersonDao():PersonDao
}