package com.lesa.pockedoc.calcs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lesa.pockedoc.R

class SubstanceInSolutionViewModel: ViewModel() {

    var percent by mutableStateOf("")
    var volume by mutableStateOf("")

    fun onPercentChanged(newPercent: String) {
        percent = newPercent
    }

    fun onVolumeChanged(newVolume: String) {
        volume = newVolume
    }

    fun isTextNotIntOrFloat(text: String): Boolean {
        val int = text.toUIntOrNull()
        val float = text.toFloatOrNull()
        return (float == null && int == null)
    }

    fun calculateSubstanceInSolutionText(percent: String, volume: String) =
        if (isTextNotIntOrFloat(percent) || isTextNotIntOrFloat(volume))
            R.string.input_mistake
        else
            R.string.substance_in_solution_result


    fun calculateSubstanceInSolution(percent: String, volume: String): Float {
        val newPercent = percent.toFloatOrNull()
        val newVolume = volume.toFloatOrNull()
        return if (newPercent != null && newVolume != null) {
            (newPercent * newVolume) / 100
        } else 0f
    }

}