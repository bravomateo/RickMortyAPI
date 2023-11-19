package com.lopezing.webserviceram.server.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Person(
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("episode")
    val episode: List<String>? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("location")
    var location: Location? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("origin")
    val origin: Origin? = null,
    @SerializedName("species")
    var species: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
):Serializable