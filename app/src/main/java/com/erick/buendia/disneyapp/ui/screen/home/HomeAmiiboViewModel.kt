package com.erick.buendia.disneyapp.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.buendia.disneyapp.domain.AddFavoriteAmiiboUseCase
import com.erick.buendia.disneyapp.domain.GetHomeAmiiboUseCase
import com.erick.buendia.disneyapp.domain.RemoveFavoriteAmiboUseCase
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeAmiiboViewModel @Inject constructor(
    private val getHomeAmiiboUseCase: GetHomeAmiiboUseCase,
    private val addFavoriteAmiiboUseCase: AddFavoriteAmiiboUseCase,
    private val removeFavoriteAmiiboUseCase: RemoveFavoriteAmiboUseCase
) : ViewModel() {

    private var _amiiboList = MutableLiveData<List<AmiiboModel>>()
    var amiiboList: LiveData<List<AmiiboModel>> = _amiiboList

    fun getAmiiboList() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getHomeAmiiboUseCase()
            _amiiboList.postValue(result)
        }
    }

    fun addFavoriteAmiibo(amiibo: AmiiboModel) {
        amiibo.isFavorite = true
        _amiiboList.postValue(amiibo)
        viewModelScope.launch(Dispatchers.IO) {
            amiiboList = _amiiboList
            addFavoriteAmiiboUseCase(amiibo.amiiboId)
        }

    }

    fun removeFavoriteAmiibo(amiibo: AmiiboModel) {
        amiibo.isFavorite = false
        _amiiboList.postValue(amiibo)
        viewModelScope.launch(Dispatchers.IO) {
            removeFavoriteAmiiboUseCase(amiibo.amiiboId)
        }
    }

}


private fun <AmiiboModel> MutableLiveData<List<AmiiboModel>>.postValue(item: AmiiboModel) {
    val currentList = this.value ?: emptyList()
    this.value = currentList + item
}
