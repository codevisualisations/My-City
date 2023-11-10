package com.fustun.projectmycity.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.fustun.projectmycity.data.CityCategories
import com.fustun.projectmycity.R
import com.fustun.projectmycity.infrastructure.CityCards
import com.fustun.projectmycity.infrastructure.CityInfrastructure
import com.fustun.projectmycity.models.RecommendationsUiState
import com.fustun.projectmycity.myCity.CityScreens

class CityDisplays {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DisplayContinents(navController: NavController, uiState:CityViewModel, modifier : Modifier = Modifier) {
        val cats = CityCategories.getCityContinents()
        Scaffold(
            topBar = {
                CityInfrastructure().CityTopBar(R.string.app_name)
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.paddingSmall))
            ) {
                items(cats) { item ->
                    CityCards().CityCard(
                        cat = item,
                        onClick = {
                            uiState.updateRecommendationsList(
                                title = item.description,
                            )
                            navController.navigate(CityScreens.RECOMMENDATIONS.name)
                        }
                    )
                }
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun DisplayCityRecommendations(navController: NavController, uiState: CityViewModel, modifier : Modifier = Modifier) {
        val recommendationsUiState by uiState.recommendationsUiState.collectAsState()
        val currentCities = recommendationsUiState.cityRecommendationsList
        Scaffold(
            topBar = {
                CityInfrastructure().CityTopBar(recommendationsUiState.topBarTitle)
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.paddingSmall))
            ) {
                items(currentCities) { city ->
                    CityCards().CityCard(
                        cat = city,
                        onClick = {}
                    )
                }
            }
        }
    }

}