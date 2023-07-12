package com.lesa.pockedoc.calcs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.lesa.pockedoc.CalcScreen
import com.lesa.pockedoc.R
import com.lesa.pockedoc.ui.theme.PockedocTheme
/*
class SubstanceInSolutionActivity : ComponentActivity() {
    private val substanceInSolutionViewModel by viewModels<SubstanceInSolutionViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PockedocTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SubstanceInSolutionScreen(viewModel = substanceInSolutionViewModel)
                }
            }
        }
    }
}*/

@Composable
fun SubstanceInSolutionScreen(
    viewModel: SubstanceInSolutionViewModel
) {
    Card(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Head(R.string.calc_substance_in_solution_title)
            InputWindow(
                value = viewModel.percent,
                onValueChange = { viewModel.onPercentChanged(it) },
                label = R.string.substance_in_solution_percent,
                isError = viewModel.isTextNotIntOrFloat(viewModel.percent),
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
            InputWindow(
                value = viewModel.volume,
                onValueChange = { viewModel.onVolumeChanged(it)},
                label = R.string.substance_in_solution_volume,
                isError = viewModel.isTextNotIntOrFloat(viewModel.volume),
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
            Spacer(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
            Text(
                    text = stringResource(
                        id = viewModel.calculateSubstanceInSolutionText(viewModel.percent, viewModel.volume),
                        viewModel.calculateSubstanceInSolution(viewModel.percent, viewModel.volume)
                    ),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(dimensionResource(id = R.dimen.padding_small)),
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall,
            )

        }
    }
}


@Composable
fun Head(title: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = title).uppercase(),
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputWindow(
    value: String,
    onValueChange: (String) -> Unit,
    label: Int,
    isError: Boolean,
    keyboardType: KeyboardType,
    imeAction: ImeAction
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = label)
            )
        },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        )

    )
}

@Composable
fun IconButtonRefresh() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .size(62.dp)
        )
    }
}

@Preview
@Composable
fun SubstanceInSolutionScreenPreviewLight() {
    PockedocTheme(darkTheme = false) {
        SubstanceInSolutionScreen(viewModel = SubstanceInSolutionViewModel())
    }
}

@Preview
@Composable
fun SubstanceInSolutionScreenPreviewDark() {
    PockedocTheme(darkTheme = true) {
        SubstanceInSolutionScreen(viewModel = SubstanceInSolutionViewModel())
    }
}
