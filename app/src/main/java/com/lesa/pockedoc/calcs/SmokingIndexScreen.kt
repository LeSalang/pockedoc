package com.lesa.pockedoc.calcs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lesa.pockedoc.R
import com.lesa.pockedoc.ui.theme.PockedocTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmokingIndexCalc () {
    val valueCigarettes = remember { mutableStateOf("") }
    val valueYears = remember { mutableStateOf("") }
    val result = remember { mutableStateOf(0) }
    val explan = remember { mutableStateOf(R.string.explanation_general) }

    Card(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                    ){
                Text(
                    text = stringResource(id = R.string.calc_smoking_title).uppercase(),
                    modifier = Modifier
                        .weight(5f)
                        .padding(start = dimensionResource(id = R.dimen.padding_small)),
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                )
                CalcItemSendButton()
                CalcItemCloseButton()
            }
            OutlinedTextField(
                value = valueCigarettes.value,
                onValueChange = {
                    valueCigarettes.value = it
                                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = stringResource(id = R.string.number_of_cigarettes))},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )
            OutlinedTextField(
                value = valueYears.value,
                onValueChange = { valueYears.value = it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(
                    text = stringResource(id = R.string.number_of_years),
                )},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                singleLine = true
            )
            Spacer(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
                    ){
                Column() {
                    Text(
                        text = stringResource(id = R.string.smoking_index_result, result.value),
                        modifier = Modifier

                            .fillMaxWidth(0.8f)
                            .padding(dimensionResource(id = R.dimen.padding_small)),
                        color = MaterialTheme.colorScheme.tertiary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleSmall,
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                    ) {
                        Text(
                            text = stringResource(id = explan.value),
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                IconButton(onClick = {
                    result.value = calcResult(valueCigarettes.value, valueYears.value)
                    explan.value = expResult(result.value)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .size(62.dp)
                    )
                }
            }
        }
    }
}

fun calcResult(valueCigarettes: String, valueYears: String): Int {
    return (inputEdition(valueCigarettes) * inputEdition(valueYears))/20
}

fun inputEdition(value: String): Int {
    return if (value.toIntOrNull() == null) 0
    else value.toInt()
}

fun expResult(value: Int) : Int {
    return when {
        (value <= 0) -> R.string.mistake
        (value in 1..10) -> R.string.smoking_index_explanation_1
        (value > 10) -> R.string.smoking_index_explanation_2
        else -> R.string.mistake
    }
}

@Composable
fun CalcItemSendButton (
    modifier: Modifier = Modifier
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Composable
fun CalcItemCloseButton (
    modifier: Modifier = Modifier
) {
    IconButton(onClick = {  }) {
        Icon(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .size(22.dp)
        )
    }
}

@Preview
@Composable
fun SmokingIndexCalcPreview () {
    PockedocTheme(darkTheme = false) {
        SmokingIndexCalc()
    }
}

@Preview
@Composable
fun SmokingIndexCalcPreviewDark () {
    PockedocTheme(darkTheme = true) {
        SmokingIndexCalc()
    }
}