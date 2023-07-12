package com.lesa.pockedoc

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lesa.pockedoc.data.Calc
import com.lesa.pockedoc.data.calc
import com.lesa.pockedoc.ui.theme.PockedocTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalcScreen () {
    Scaffold(
        topBar = {
            CalcTopAppBar()
        }
    ) { it ->
        LazyColumn(
            contentPadding = it,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            items (calc) {
                CalcItem(
                    calc = it,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalcTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.normal_image_size)),
                    painter = painterResource(id = R.drawable.baseline_medical_information_24),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary)
                )
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = stringResource(id = R.string.app_name).uppercase(),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.tertiary

                )
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_small)))
                Image(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.normal_image_size)),
                painter = painterResource(id = R.drawable.baseline_medical_information_24),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary)
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun CalcItem (
    calc: Calc,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(calc.calcNameRes),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(5f)
                        .padding(start = dimensionResource(id = R.dimen.padding_small)),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = if (!expanded) 1 else 5,
                    overflow = TextOverflow.Ellipsis

                )
                CalcItemExpandButton(
                    expanded = expanded,
                    onClick = {
                        expanded = !expanded
                    }
                )
                CalcItemOpenButton(
                    modifier = Modifier
                      //  .weight(1f)
                )
            }
            if (expanded) {
                CalcDescription(
                    calcDescription = calc.calcDescriptionRes,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun CalcItemExpandButton (
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
    ) {
        Icon(
            imageVector = if (!expanded) Icons.Filled.ExpandMore else Icons.Filled.ExpandLess,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Composable
fun CalcItemOpenButton (
    modifier: Modifier = Modifier
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.OpenInNew,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun CalcDescription (
    @StringRes calcDescription: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(calcDescription),
        modifier = Modifier,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Preview
@Composable
fun CalcScreenDarkPreview () {
    PockedocTheme(darkTheme = true) {
        CalcScreen()
    }
}

@Preview
@Composable
fun CalcScreenLightPreview () {
    PockedocTheme(darkTheme = false) {
        CalcScreen()
    }
}

