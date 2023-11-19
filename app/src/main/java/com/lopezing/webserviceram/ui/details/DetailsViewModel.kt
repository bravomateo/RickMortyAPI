package com.lopezing.webserviceram.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lopezing.webserviceram.local.LocalPerson
import com.lopezing.webserviceram.local.repository.LocalPersonRepository
import com.lopezing.webserviceram.server.model.Person
import kotlinx.coroutines.launch
import java.sql.Types.NULL

class DetailsViewModel : ViewModel() {

    private val _personFavorite : MutableLiveData<Boolean> = MutableLiveData()
    var personFavorite: LiveData<Boolean> =_personFavorite
    private val localPersonRepository = LocalPersonRepository()

    fun addPersonToFavorites(person: Person) {
        val localPerson=LocalPerson(
            id=NULL,
            name =person.name,
            image = person.image,
            gender = person.gender,
            species = person.species,
            status = person.location?.name,
            origin=person.origin?.name)

        viewModelScope.launch {
            localPersonRepository.savePerson(localPerson)
        }

    }

    fun favoriteOn(person: Person) {
        var band=false
        viewModelScope.launch {
            val result = localPersonRepository.searchFavorite(person.name)
            if (result != null) band = true
            _personFavorite.postValue(band)
        }

    }
}