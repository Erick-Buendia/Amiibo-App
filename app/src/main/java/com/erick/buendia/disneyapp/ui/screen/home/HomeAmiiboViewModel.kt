package com.erick.buendia.disneyapp.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.buendia.disneyapp.domain.GetHomeAmiiboUseCase
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeAmiiboViewModel : ViewModel() {

    private val getHomeAmiiboUseCase = GetHomeAmiiboUseCase()

    private val _amiiboList = MutableLiveData<List<AmiiboModel>>()
    val amiiboList: LiveData<List<AmiiboModel>> = _amiiboList

    fun getAmiiboList() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getHomeAmiiboUseCase()
            _amiiboList.postValue(result)
        }
    }


}