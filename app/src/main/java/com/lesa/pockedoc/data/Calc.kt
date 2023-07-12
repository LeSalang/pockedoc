package com.lesa.pockedoc.data

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.lesa.pockedoc.R
import com.lesa.pockedoc.calcs.SubstanceInSolutionViewModel

data class Calc(
    @StringRes val calcNameRes: Int,
    @StringRes val calcDescriptionRes: Int
)

val calc = listOf(
    Calc(R.string.calc_glucocorticoids_title, R.string.calc_glucocorticoids_description),
    Calc(R.string.calc_smoking_title, R.string.calc_smoking_description),
    Calc(R.string.calc_score2_title, R.string.calc_score2_description),
    Calc(R.string.calc_substance_in_solution_title, R.string.calc_substance_in_solution_description),
    Calc(R.string.glasgow_coma_scale_title, R.string.glasgow_coma_scale_description),
)

