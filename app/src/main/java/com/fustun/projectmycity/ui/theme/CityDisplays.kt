package com.fustun.projectmycity.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.fustun.projectmycity.R
import com.fustun.projectmycity.infrastructure.CityCards
import com.fustun.projectmycity.infrastructure.CityInfrastructure
import com.fustun.projectmycity.models.CityModels
import com.fustun.projectmycity.myCity.CityScreens


class CityDisplays {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DisplayContinentsAndRecommendations(
        navController: NavController,
        uiState: CityViewModel,
        items: List<CityModels>,
        topBarTitle: Int,
        topBarCanNavigateBack : Boolean,
        modifier: Modifier = Modifier
    ) {

        Scaffold(
            topBar = {
                CityInfrastructure().CityTopBar(
                    topBarTitle,
                    topBarCanNavigateBack,
                    navigateUp = {navController.navigateUp()}
                )
            }
        ) { innerPadding ->
            Column(modifier = modifier.padding(innerPadding)){
                LazyColumn(
                    modifier = modifier.weight(0.9f),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.paddingSmall))
                ) {
                    items(items) { item ->
                        when (item) {
                            is CityModels.Continent -> {
                                CityCards().ContinentOrCityCard(
                                    cat = item,
                                    onClick = {
                                        uiState.updateRecommendationsList(title = item.name)
                                        uiState.updateTopBarTitle(title = item.name)
                                        navController.navigate(CityScreens.RECOMMENDATIONS.name)
                                    }
                                )
                            }
                            is CityModels.Cities -> {
                                CityCards().ContinentOrCityCard(
                                    cat = item,
                                    onClick = {
                                        uiState.updateCurrentAttraction(title = item.name)
                                        uiState.updatePreviousTopBarTitle(title = topBarTitle)
                                        uiState.updateTopBarTitle(title = item.name)
                                        navController.navigate(CityScreens.PLACE.name)
                                    }
                                )
                            }
                            else -> {}
                        }
                    }
                }
                if (topBarCanNavigateBack){
                    CityInfrastructure().CityCancelButton(
                        onCancelButtonClicked = {navController.popBackStack(CityScreens.ROOT.name,inclusive = false)},
                        modifier = modifier.weight(0.1f)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DisplayCityCities(
        currentCity : CityModels.Attractions,
        uiState: CityViewModel,
        navController: NavController,
        topBarTitle: Int,
        previousTopBarTitle: Int,
        topBarCanNavigateBack : Boolean,
        modifier: Modifier = Modifier
    ){
        Scaffold(
            topBar = {
                CityInfrastructure().CityTopBar(
                    topBarTitle,
                    topBarCanNavigateBack,
                    navigateUp = {
                        uiState.updateTopBarTitle(previousTopBarTitle)
                        navController.navigateUp()
                    }
                )
            }
        ){ innerPadding ->
            Column(
                modifier = modifier.padding(innerPadding)
            ){
                Column(
                    modifier = modifier
                        .weight(0.9f)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    CityCards().CityCityCard(currentCity)
                }
                CityInfrastructure().CityCancelButton(
                    onCancelButtonClicked = {navController.popBackStack(CityScreens.ROOT.name,inclusive = false)},
                    modifier = modifier
                        .weight(0.1f)
                        .fillMaxHeight()
                )
            }
        }
    }

    @Composable
    fun FormCityContinents(navController: NavController, uiState: CityViewModel, modifier: Modifier = Modifier) {
        val currentUiState by uiState.cityUiState.collectAsState()

        val continents = currentUiState.cityContinentsList
        val topBarTitle = R.string.app_name
        val topBarCanNavigateBack = navController.previousBackStackEntry != null
        DisplayContinentsAndRecommendations(navController, uiState, continents, topBarTitle, topBarCanNavigateBack, modifier)
    }

    @Composable
    fun FormCityRecommendations(navController: NavController, uiState: CityViewModel, modifier:Modifier=Modifier){
        val currentUiState by uiState.cityUiState.collectAsState()

        val currentCityRecommendations = currentUiState.cityRecommendationsList
        val currentCityTopBarTitle = currentUiState.topBarTitle
        val topBarCanNavigateBack = navController.previousBackStackEntry != null
        DisplayContinentsAndRecommendations(navController, uiState, currentCityRecommendations, currentCityTopBarTitle, topBarCanNavigateBack, modifier)
    }

    @Composable
    fun FormCityCities(navController: NavController, uiState: CityViewModel){
        val currentUiState by uiState.cityUiState.collectAsState()

        val currentCityAttraction = currentUiState.cityAttraction
        val currentAttractionTopBarTitle = currentUiState.topBarTitle
        val topBarCanNavigateBack = navController.previousBackStackEntry != null
        val previousTopBarTitle = currentUiState.previousTopBarTitle

        DisplayCityCities(
            currentCity = currentCityAttraction,
            uiState = uiState,
            navController = navController,
            topBarTitle = currentAttractionTopBarTitle,
            previousTopBarTitle = previousTopBarTitle,
            topBarCanNavigateBack = topBarCanNavigateBack
        )
    }
}