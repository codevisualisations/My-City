package com.fustun.projectmycity.data

import com.fustun.projectmycity.R
import com.fustun.projectmycity.models.CityModels

object CityCategories {
    val attractionsMap: HashMap<Int, CityModels.Attractions> = hashMapOf(
        R.string.britishMuseum to CityModels.Attractions(R.string.britishMuseum, R.string.britishMuseumDescription, R.drawable.asia),
        R.string.towerOfLondon to CityModels.Attractions(R.string.towerOfLondon, R.string.towerOfLondonDescription, R.drawable.asia),
        R.string.buckinghamPalace to CityModels.Attractions(R.string.buckinghamPalace, R.string.buckinghamPalaceDescription, R.drawable.asia),
        R.string.indiaGate to CityModels.Attractions(R.string.indiaGate, R.string.indiaGateDescription, R.drawable.asia),
        R.string.lotusTemple to CityModels.Attractions(R.string.lotusTemple, R.string.lotusTempleDescription, R.drawable.asia),
        R.string.qutubMinar to CityModels.Attractions(R.string.qutubMinar, R.string.qutubMinarDescription, R.drawable.asia),
        R.string.humayunTomb to CityModels.Attractions(R.string.humayunTomb, R.string.humayunTombDescription, R.drawable.asia),
        R.string.redFort to CityModels.Attractions(R.string.redFort, R.string.redFortDescription, R.drawable.asia),
        R.string.chandniChowk to CityModels.Attractions(R.string.chandniChowk, R.string.chandniChowkDescription, R.drawable.asia),
        R.string.akshardhamTemple to CityModels.Attractions(R.string.akshardhamTemple, R.string.akshardhamTempleDescription, R.drawable.asia),
        R.string.handloomMuseum to CityModels.Attractions(R.string.handloomMuseum, R.string.handloomMuseumDescription, R.drawable.asia),
        R.string.centralPark to CityModels.Attractions(R.string.centralPark, R.string.centralParkDescription, R.drawable.asia),
        R.string.timesSquare to CityModels.Attractions(R.string.timesSquare, R.string.timesSquareDescription, R.drawable.asia),
        R.string.statueOfLiberty to CityModels.Attractions(R.string.statueOfLiberty, R.string.statueOfLibertyDescription, R.drawable.asia),
        R.string.sydneyOperaHouse to CityModels.Attractions(R.string.sydneyOperaHouse, R.string.sydneyOperaHouseDescription, R.drawable.asia),
        R.string.tarongaZoo to CityModels.Attractions(R.string.tarongaZoo, R.string.tarongaZooDescription, R.drawable.asia),
        R.string.royalBotanicGarden to CityModels.Attractions(R.string.royalBotanicGarden, R.string.royalBotanicGardenDescription, R.drawable.asia)
    )
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
            CityModels.Cities(R.string.britishMuseum, R.drawable.emea),
            CityModels.Cities(R.string.buckinghamPalace, R.drawable.amer),
            CityModels.Cities(R.string.towerOfLondon, R.drawable.asia),
        )
    }

    fun getCityRecommendationsNewDelhi() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.indiaGate, R.drawable.emea),
            CityModels.Cities(R.string.lotusTemple, R.drawable.amer),
            CityModels.Cities(R.string.qutubMinar, R.drawable.asia),
            CityModels.Cities(R.string.humayunTomb, R.drawable.amer),
            CityModels.Cities(R.string.redFort, R.drawable.asia),
            CityModels.Cities(R.string.chandniChowk, R.drawable.amer),
            CityModels.Cities(R.string.akshardhamTemple, R.drawable.asia),
            CityModels.Cities(R.string.handloomMuseum, R.drawable.amer),

        )
    }

    fun getCityRecommendationsNewYork() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.centralPark, R.drawable.emea),
            CityModels.Cities(R.string.statueOfLiberty, R.drawable.amer),
            CityModels.Cities(R.string.timesSquare, R.drawable.asia),
        )
    }

    fun getCityRecommendationsSydney() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.sydneyOperaHouse, R.drawable.emea),
            CityModels.Cities(R.string.royalBotanicGarden, R.drawable.amer),
            CityModels.Cities(R.string.tarongaZoo, R.drawable.asia),
        )
    }

    fun getCityAttraction(description: Int): CityModels.Attractions {
        return attractionsMap[description] ?: CityModels.Attractions(R.string.redFort, R.string.redFortDescription, R.drawable.asia)
    }
}