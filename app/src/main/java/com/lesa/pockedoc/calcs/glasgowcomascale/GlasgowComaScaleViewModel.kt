package com.lesa.pockedoc.calcs.glasgowcomascale

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GlasgowComaScaleViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(GlasgowComaScaleUiState())
    val uiState: StateFlow<GlasgowComaScaleUiState> = _uiState.asStateFlow()
}