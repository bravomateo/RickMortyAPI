package com.lopezing.webserviceram.server.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Origin(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    val url: String? = null
):Serializable