package com.fustun.projectmycity.myCity

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import com.fustun.projectmycity.infrastructure.CityInfrastructure
import com.fustun.projectmycity.ui.theme.CityDisplays
import com.fustun.projectmycity.ui.theme.ProjectMyCityTheme
import com.fustun.projectmycity.R
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fustun.projectmycity.ui.theme.CityViewModel

class City {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RunMyCity() {
        val navController = CityInfrastructure().cityNavigation()
        val uiState= CityInfrastructure().cityViewModel()

        NavHost(
            navController = navController,
            startDestination = CityScreens.ROOT.name
        ) {
            composable(route = CityScreens.ROOT.name) {
                CityDisplays().DisplayContinents(
                    navController,
                    uiState
                )
            }
            composable(route = CityScreens.RECOMMENDATIONS.name){
                CityDisplays().DisplayCityRecommendations(
                    navController,
                    uiState
                )
            }
        }
    }
}


enum class CityScreens(){
    ROOT,
    RECOMMENDATIONS
}

@Preview
@Composable
fun CityPreview(){
    ProjectMyCityTheme(darkTheme = true) {
        City().RunMyCity()
    }
}