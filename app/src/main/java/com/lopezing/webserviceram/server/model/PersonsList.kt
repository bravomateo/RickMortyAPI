package com.lopezing.webserviceram.server.model


import com.google.gson.annotations.SerializedName

data class PersonsList(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val people: List<Person>? = null
)