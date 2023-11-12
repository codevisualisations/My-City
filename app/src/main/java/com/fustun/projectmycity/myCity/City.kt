package com.fustun.projectmycity.myCity

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fustun.projectmycity.infrastructure.CityInfrastructure
import com.fustun.projectmycity.ui.theme.CityDisplays
import com.fustun.projectmycity.ui.theme.ProjectMyCityTheme

class City {
    @Composable
    fun RunMyCity() {
        val navController = CityInfrastructure().cityNavigation()
        val uiState= CityInfrastructure().cityViewModel()

        NavHost(
            navController = navController,
            startDestination = CityScreens.ROOT.name
        ) {
            composable(route = CityScreens.ROOT.name) {
                CityDisplays().FormCityContinents(
                    navController,
                    uiState
                )
            }
            composable(route = CityScreens.RECOMMENDATIONS.name){
                CityDisplays().FormCityRecommendations(
                    navController,
                    uiState
                )
            }
            composable(route = CityScreens.PLACE.name){
                CityDisplays().FormCityCities(
                    navController,
                    uiState
                )
            }
        }
    }
}


enum class CityScreens{
    ROOT,
    RECOMMENDATIONS,
    PLACE
}

@Preview
@Composable
fun CityPreview(){
    ProjectMyCityTheme(darkTheme = true) {
        City().RunMyCity()
    }
}