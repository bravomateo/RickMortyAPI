package com.lopezing.webserviceram.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

    @Insert
    suspend fun createPerson(person: LocalPerson)

    @Query("SELECT * FROM name")
    suspend fun getFavorite():MutableList<LocalPerson>

    @Delete
    suspend fun favoriteDelete(localPerson: LocalPerson)

    @Query("SELECT * FROM name WHERE name LIKE :name")
    suspend fun searchFavorite(name: String?):LocalPerson

}