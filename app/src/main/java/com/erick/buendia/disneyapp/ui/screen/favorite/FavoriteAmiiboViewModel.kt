package com.erick.buendia.disneyapp.ui.screen.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.erick.buendia.disneyapp.domain.GetFavoriteAmiiboUseCase
import com.erick.buendia.disneyapp.domain.GetHomeAmiiboUseCase
import com.erick.buendia.disneyapp.domain.RemoveFavoriteAmiboUseCase
import com.erick.buendia.disneyapp.domain.model.AmiiboModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteAmiiboViewModel @Inject constructor(
    private val getFavoriteAmiiboUseCase: GetFavoriteAmiiboUseCase,
    private val removeFavoriteAmiiboUseCase: RemoveFavoriteAmiboUseCase
) : ViewModel() {
    private var _amiiboListFavorite = MutableLiveData<List<AmiiboModel>>()
    var amiiboListFavorite: LiveData<List<AmiiboModel>> = _amiiboListFavorite

    fun getAmiiboListFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getFavoriteAmiiboUseCase()
            _amiiboListFavorite.postValue(result)
        }
    }

    fun removeFavoriteAmiibo(amiibo: AmiiboModel) {

        viewModelScope.launch(Dispatchers.IO) {
            removeFavoriteAmiiboUseCase(amiibo.amiiboId)
            val result = getFavoriteAmiiboUseCase()
            _amiiboListFavorite.postValue(result)
        }
    }
}
