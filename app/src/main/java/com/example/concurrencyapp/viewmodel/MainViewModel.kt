package com.example.concurrencyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.concurrencyapp.repository.ApiRepository
import com.example.concurrencyapp.response.ResponseCoinsList
import com.example.concurrencyapp.utils.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    /**
     * List of Coins
     */

    private val _coinsList =
        MutableLiveData<DataStatus<List<ResponseCoinsList.ResponseCoinsListItem>>>()
    val coinsList: LiveData<DataStatus<List<ResponseCoinsList.ResponseCoinsListItem>>>
        get() = _coinsList


    fun getCoinsList(vs_currency: String) = viewModelScope.launch {
        repository.getCoinsList(vs_currency).collect {
            _coinsList.value = it
        }
    }

}