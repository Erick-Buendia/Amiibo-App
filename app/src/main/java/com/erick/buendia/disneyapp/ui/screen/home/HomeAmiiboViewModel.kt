package com.erick.buendia.disneyapp.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.buendia.disneyapp.data.HomeAmiiboRepository
import com.erick.buendia.disneyapp.data.model.Amiibo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeAmiiboViewModel : ViewModel() {

    private val getHomeAmiiboRepository = HomeAmiiboRepository()

    private val _amiiboList = MutableLiveData<List<Amiibo>>()
    val amiiboList: LiveData<List<Amiibo>> = _amiiboList



    fun getAmiiboList() {
        viewModelScope.launch(Dispatchers.IO) {

            val result = getHomeAmiiboRepository.getAmiiboList()
            _amiiboList.postValue(result)
        }
    }


}