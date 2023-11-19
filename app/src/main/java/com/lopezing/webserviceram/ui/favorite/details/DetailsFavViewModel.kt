package com.lopezing.webserviceram.ui.favorite.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lopezing.webserviceram.local.LocalPerson
import com.lopezing.webserviceram.local.repository.LocalPersonRepository
import com.lopezing.webserviceram.server.model.Person
import kotlinx.coroutines.launch
import java.sql.Types

class DetailsFavViewModel : ViewModel() {
    private val _personFavorite : MutableLiveData<Boolean> = MutableLiveData()
    var personFavorite: LiveData<Boolean> =_personFavorite
    private val localPersonRepository = LocalPersonRepository()
    fun addPersonToFavorites(person: LocalPerson) {
        val localPerson= LocalPerson(
            id= Types.NULL,
            name =person.name,
            image = person.image,
            gender = person.gender,
            species = person.species,
            status = person.status,
            origin=person.origin)

        viewModelScope.launch {
            localPersonRepository.savePerson(localPerson)
        }


    }

}