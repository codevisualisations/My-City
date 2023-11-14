package com.fustun.projectmycity.ui.theme

import androidx.lifecycle.ViewModel
import com.fustun.projectmycity.R
import com.fustun.projectmycity.data.CityCategories
import com.fustun.projectmycity.models.CityModels
import com.fustun.projectmycity.models.CityUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {
    private val _CityUiState = MutableStateFlow(CityUiState())
    val cityUiState : StateFlow<CityUiState> = _CityUiState.asStateFlow()
    fun updateRecommendationsList(title: Int) {
        _CityUiState.update {
            when (title) {
                R.string.EMEA -> it.copy(
                    topBarTitle = R.string.LONDON,
                    cityRecommendationsList = CityCategories.getCityRecommendationsLondon()
                )
                R.string.AMER -> it.copy(
                    topBarTitle = R.string.NEW_YORK,
                    cityRecommendationsList = CityCategories.getCityRecommendationsNewYork()
                )
                R.string.ASIA -> it.copy(
                    topBarTitle = R.string.NEW_DELHI,
                    cityRecommendationsList = CityCategories.getCityRecommendationsNewDelhi()
                )
                R.string.OCEANIA -> it.copy(
                    topBarTitle = R.string.SYDNEY,
                    cityRecommendationsList = CityCategories.getCityRecommendationsSydney()
                )
                else -> it
            }
        }
    }

    fun updateCurrentAttraction(title: Int){
        _CityUiState.update {
            it.copy(
                cityAttraction = CityCategories.getCityAttraction(title)
            )
        }
    }

    fun updateTopBarTitle(title : Int){
        _CityUiState.update {
            it.copy(
                topBarTitle = title
            )
        }
    }

    fun updatePreviousTopBarTitle(title:Int){
        _CityUiState.update {
            it.copy(
                previousTopBarTitle = title
            )
        }
    }
}
