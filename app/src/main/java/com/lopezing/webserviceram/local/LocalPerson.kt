package com.lopezing.webserviceram.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="name")
data class LocalPerson (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id:Int,
    @ColumnInfo(name = "name")val name:String?,
    @ColumnInfo(name = "image")val image:String?,
    @ColumnInfo(name = "species")val species:String?,
    @ColumnInfo(name = "gender")val gender:String?,
    @ColumnInfo(name = "origin")val origin:String?,
    @ColumnInfo(name = "status")val status:String?
        ):Serializable