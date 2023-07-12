package com.lesa.pockedoc.calcs

data class SmokingIndexStates(
    val numberOfCigarettes: Int = 0,
    val numberOfYears: Int = 0,
    val smokingIndex: Int = 0,
    val riskOfCopd: Boolean = false
)

const val SMOKING_INDEX = 10