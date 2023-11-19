package com.lopezing.webserviceram.local.repository

import com.lopezing.webserviceram.WebServiceRaM
import com.lopezing.webserviceram.local.LocalPerson
import com.lopezing.webserviceram.local.PersonDao

class LocalPersonRepository {

    suspend fun savePerson(localPerson: LocalPerson) {

        val personDao : PersonDao = WebServiceRaM.database.PersonDao()
        personDao.createPerson(localPerson)
    }

    suspend fun getFavorite() =WebServiceRaM.database.PersonDao().getFavorite()

    suspend fun favoriteDelete(localPerson: LocalPerson) {
        val personDao : PersonDao = WebServiceRaM.database.PersonDao()
        personDao.favoriteDelete(localPerson)
    }

    suspend fun searchFavorite(name:String?) = WebServiceRaM.database.PersonDao().searchFavorite(name)

}