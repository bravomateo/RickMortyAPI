package com.lopezing.webserviceram.server

import com.lopezing.webserviceram.server.model.PersonsList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getPersons(@Query("page") page: Int) : PersonsList




}