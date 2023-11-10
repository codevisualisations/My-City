package com.fustun.projectmycity.ui.theme

import androidx.lifecycle.ViewModel
import com.fustun.projectmycity.R
import com.fustun.projectmycity.data.CityCategories
import com.fustun.projectmycity.models.RecommendationsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {
    private val _RecommendationsUiState = MutableStateFlow(RecommendationsUiState())
    val recommendationsUiState : StateFlow<RecommendationsUiState> = _RecommendationsUiState.asStateFlow()


    fun updateRecommendationsList(title : Int){
        if (title == R.string.EMEA){
            _RecommendationsUiState.update {
                it.copy(
                    topBarTitle = R.string.LONDON,
                    cityRecommendationsList = CityCategories.getCityRecommendationsLondon()
                )
            }
        }
    }

}