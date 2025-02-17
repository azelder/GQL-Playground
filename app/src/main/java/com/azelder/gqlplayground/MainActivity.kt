package com.azelder.gqlplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import com.azelder.gqlplayground.presentation.CountriesViewModel
import com.azelder.gqlplayground.ui.theme.GQLPlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.azelder.gqlplayground.presentation.CountriesScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GQLPlaygroundTheme {
                val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()
                CountriesScreen(
                    state = state,
                    onSelectcountry = viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}
