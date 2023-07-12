package com.lesa.pockedoc.calcs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SmokingIndexViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SmokingIndexStates())
    val uiState: StateFlow<SmokingIndexStates> = _uiState.asStateFlow()

    var numberOfCigarettes by mutableStateOf("")
    var numberOfYears by mutableStateOf("")

    public fun calculateSmokingIndex (numberOfCigarettes: String?, numberOfYears: String?) : String {
        val result = ((numberOfCigarettes?.toInt() ?: 0) * (numberOfYears?.toInt() ?: 0)) / 20
        return result.toString()
    }

}