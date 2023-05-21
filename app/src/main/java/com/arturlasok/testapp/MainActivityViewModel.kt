package com.arturlasok.testapp

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arturlasok.testapp.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
    ) : ViewModel() {
    //dark mode
    private val isDarkActive = savedStateHandle.getStateFlow("isDarkActive",false)


    val uiState : Flow<MainActivityUiState> = combine(isDarkActive) { isDarkactive ->
        Log.i(TAG,"Data is changed VM")


        MainActivityUiState.Loading



    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(1000), MainActivityUiState.Loading)

    fun setDarkActiveTo(newVal: Boolean) {
       savedStateHandle["isDarkActive"] = newVal
    }


}