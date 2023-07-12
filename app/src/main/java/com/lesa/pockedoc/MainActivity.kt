package com.lesa.pockedoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lesa.pockedoc.calcs.SubstanceInSolutionScreen
import com.lesa.pockedoc.calcs.SubstanceInSolutionViewModel
import com.lesa.pockedoc.ui.theme.PockedocTheme

class MainActivity : ComponentActivity() {
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
                    CalcScreen()
                    SubstanceInSolutionScreen(viewModel = substanceInSolutionViewModel)
                }
            }
        }
    }
}

