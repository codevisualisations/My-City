package com.fustun.projectmycity.models
import com.fustun.projectmycity.R
import com.fustun.projectmycity.data.CityCategories

data class CityUiState(
    val topBarTitle : Int = R.string.app_name,
    val previousTopBarTitle : Int = R.string.app_name,
    val cityRecommendationsList : List<CityModels.Cities> = CityCategories.getCityRecommendationsLondon(),
    val cityContinentsList : List<CityModels.Continent> = CityCategories.getCityContinents(),
    val cityAttraction : CityModels.Attractions = CityCategories.getCityAttraction(R.string.britishMuseum),
    val currentExpandedAttractionCard : CityModels.Attractions = CityCategories.getCityAttraction(R.string.britishMuseum),
)
