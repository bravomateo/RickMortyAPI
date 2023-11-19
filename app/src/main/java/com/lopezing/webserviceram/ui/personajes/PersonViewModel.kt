package com.lopezing.webserviceram.ui.personajes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lopezing.webserviceram.server.RickAndMortyRepository.RickAndMortyRepository
import com.lopezing.webserviceram.server.model.Person
import com.lopezing.webserviceram.server.model.PersonsList
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {
    private val rickAndMortyRepository = RickAndMortyRepository()
    private val _personObserve:MutableLiveData<ArrayList<Person>> = MutableLiveData()
    val personObserve:LiveData<ArrayList<Person>> =_personObserve

    fun getRaM(){
        viewModelScope.launch {
            val personsList: PersonsList = rickAndMortyRepository.getPersons()
            _personObserve.postValue(personsList.people as ArrayList<Person>)

        }
    }
}