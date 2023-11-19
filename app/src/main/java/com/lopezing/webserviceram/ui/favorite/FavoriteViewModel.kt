package com.lopezing.webserviceram.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lopezing.webserviceram.local.LocalPerson
import com.lopezing.webserviceram.local.repository.LocalPersonRepository
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {
    private val localPersonRepository=LocalPersonRepository()
    private val _personLoad : MutableLiveData<ArrayList<LocalPerson>> = MutableLiveData()
    var personLoad:LiveData<ArrayList<LocalPerson>> =_personLoad
    fun loadFavorite() {
        viewModelScope.launch {
            val listFavoritePerson = localPersonRepository.getFavorite()
            _personLoad.postValue(listFavoritePerson as ArrayList<LocalPerson>)
        }
    }

    fun favoriteDelete(localPerson: LocalPerson) {
        viewModelScope.launch {
            localPersonRepository.favoriteDelete(localPerson)

        loadFavorite()}
    }
}