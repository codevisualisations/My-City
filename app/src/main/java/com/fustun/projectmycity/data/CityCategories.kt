package com.fustun.projectmycity.data

import com.fustun.projectmycity.R
import com.fustun.projectmycity.models.CityModels

object CityCategories {
    val attractionsMap: HashMap<Int, CityModels.Attractions> = hashMapOf(
        R.string.app_name to CityModels.Attractions(R.string.app_name,R.string.welcome,R.drawable.new_app_logo),
        R.string.britishMuseum to CityModels.Attractions(R.string.britishMuseum, R.string.britishMuseumDescription, R.drawable.britishmuseum_jpg),
        R.string.towerOfLondon to CityModels.Attractions(R.string.towerOfLondon, R.string.towerOfLondonDescription, R.drawable.toweroflondon),
        R.string.buckinghamPalace to CityModels.Attractions(R.string.buckinghamPalace, R.string.buckinghamPalaceDescription, R.drawable.buckinghampalace),
        R.string.indiaGate to CityModels.Attractions(R.string.indiaGate, R.string.indiaGateDescription, R.drawable.indiagate),
        R.string.lotusTemple to CityModels.Attractions(R.string.lotusTemple, R.string.lotusTempleDescription, R.drawable.lotustemple),
        R.string.qutubMinar to CityModels.Attractions(R.string.qutubMinar, R.string.qutubMinarDescription, R.drawable.qutubminar),
        R.string.humayunTomb to CityModels.Attractions(R.string.humayunTomb, R.string.humayunTombDescription, R.drawable.humayuntomb),
        R.string.redFort to CityModels.Attractions(R.string.redFort, R.string.redFortDescription, R.drawable.redfort),
        R.string.chandniChowk to CityModels.Attractions(R.string.chandniChowk, R.string.chandniChowkDescription, R.drawable.chandnichowk_jpg),
        R.string.akshardhamTemple to CityModels.Attractions(R.string.akshardhamTemple, R.string.akshardhamTempleDescription, R.drawable.akshardhamtemple),
        R.string.handloomMuseum to CityModels.Attractions(R.string.handloomMuseum, R.string.handloomMuseumDescription, R.drawable.handloommuseum),
        R.string.centralPark to CityModels.Attractions(R.string.centralPark, R.string.centralParkDescription, R.drawable.centralpark),
        R.string.timesSquare to CityModels.Attractions(R.string.timesSquare, R.string.timesSquareDescription, R.drawable.timessquare_jpg),
        R.string.statueOfLiberty to CityModels.Attractions(R.string.statueOfLiberty, R.string.statueOfLibertyDescription, R.drawable.statueofliberty),
        R.string.sydneyOperaHouse to CityModels.Attractions(R.string.sydneyOperaHouse, R.string.sydneyOperaHouseDescription, R.drawable.sydneyoperahouse),
        R.string.tarongaZoo to CityModels.Attractions(R.string.tarongaZoo, R.string.tarongaZooDescription, R.drawable.tarongazoo),
        R.string.royalBotanicGarden to CityModels.Attractions(R.string.royalBotanicGarden, R.string.royalBotanicGardenDescription, R.drawable.royalbotanicgarden_jpg)
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
            CityModels.Cities(R.string.britishMuseum, R.drawable.britishmuseum_jpg),
            CityModels.Cities(R.string.buckinghamPalace, R.drawable.buckinghampalace),
            CityModels.Cities(R.string.towerOfLondon, R.drawable.toweroflondon),
        )
    }

    fun getCityRecommendationsNewDelhi() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.indiaGate, R.drawable.indiagate),
            CityModels.Cities(R.string.lotusTemple, R.drawable.lotustemple),
            CityModels.Cities(R.string.qutubMinar, R.drawable.qutubminar),
            CityModels.Cities(R.string.humayunTomb, R.drawable.humayuntomb),
            CityModels.Cities(R.string.redFort, R.drawable.redfort),
            CityModels.Cities(R.string.chandniChowk, R.drawable.chandnichowk_jpg),
            CityModels.Cities(R.string.akshardhamTemple, R.drawable.akshardhamtemple),
            CityModels.Cities(R.string.handloomMuseum, R.drawable.handloommuseum),

        )
    }

    fun getCityRecommendationsNewYork() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.centralPark, R.drawable.centralpark),
            CityModels.Cities(R.string.statueOfLiberty, R.drawable.statueofliberty),
            CityModels.Cities(R.string.timesSquare, R.drawable.timessquare_jpg),
        )
    }

    fun getCityRecommendationsSydney() : List<CityModels.Cities>{
        return listOf(
            CityModels.Cities(R.string.sydneyOperaHouse, R.drawable.sydneyoperahouse),
            CityModels.Cities(R.string.royalBotanicGarden, R.drawable.royalbotanicgarden_jpg),
            CityModels.Cities(R.string.tarongaZoo, R.drawable.tarongazoo),
        )
    }

    fun getCityAttraction(description: Int): CityModels.Attractions {
        return attractionsMap[description] ?: CityModels.Attractions(R.string.app_name, R.string.welcome, R.drawable.new_app_logo)
    }
}