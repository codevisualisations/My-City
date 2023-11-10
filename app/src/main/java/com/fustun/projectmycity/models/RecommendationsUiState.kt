package com.fustun.projectmycity.models
import com.fustun.projectmycity.R
import com.fustun.projectmycity.data.CityCategories

data class RecommendationsUiState(
    val topBarTitle : Int = R.string.app_name,
    val cityRecommendationsList : List<CityModels.Cities> = CityCategories.getCityRecommendationsLondon(),
)
