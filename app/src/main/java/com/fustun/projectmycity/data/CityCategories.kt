package com.fustun.projectmycity.data

import com.fustun.projectmycity.R
import com.fustun.projectmycity.models.CityModels

object CityCategories {

    fun getCityContinents() : List<CityModels.Continent>{
        return listOf(
            CityModels.Continent(R.string.EMEA, R.drawable.emea),
            CityModels.Continent(R.string.AMER, R.drawable.amer),
            CityModels.Continent(R.string.ASIA, R.drawable.asia),
            CityModels.Continent(R.string.OCEANIA, R.drawable.ocenia)
        )
    }

    fun getCityRecommendationsLondon() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.londonMinistry, R.drawable.emea),
            CityModels.Cities(R.string.londonMinistry, R.drawable.amer),
            CityModels.Cities(R.string.londonMinistry, R.drawable.asia),
            CityModels.Cities(R.string.londonMinistry, R.drawable.ocenia)
        )
    }
}