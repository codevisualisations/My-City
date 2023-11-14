package com.fustun.projectmycity.myCity

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fustun.projectmycity.infrastructure.CityInfrastructure
import com.fustun.projectmycity.ui.theme.CityDisplays
import com.fustun.projectmycity.utils.CityContentType

class City {
    @Composable
    fun RunMyCity(
        windowSize: WindowWidthSizeClass
    ) {
        val navController = CityInfrastructure().cityNavigation()
        val uiState= CityInfrastructure().cityViewModel()
        val contentType = when (windowSize){
            WindowWidthSizeClass.Expanded -> CityContentType.ListAndDetail
            else -> CityContentType.ListOnly
        }


        NavHost(
            navController = navController,
            startDestination = CityScreens.ROOT.name
        ) {
            composable(route = CityScreens.ROOT.name) {
                CityDisplays().FormCityContinents(
                    contentType = contentType,
                    navController,
                    uiState
                )
            }
            composable(route = CityScreens.RECOMMENDATIONS.name){
                CityDisplays().FormCityRecommendations(
                    contentType = contentType,
                    navController,
                    uiState
                )
            }
            composable(route = CityScreens.PLACE.name){
                CityDisplays().FormCityCities(
                    contentType = contentType,
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

