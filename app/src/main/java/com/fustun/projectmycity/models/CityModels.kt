package com.fustun.projectmycity.models

sealed class CityModels(
    open val description : Int,
    open val image : Int,
){
    data class Continent(
        override val description : Int,
        override val image: Int,
    ) : CityModels(description,image)

    data class Cities(
        override  val description: Int,
        override  val image: Int,
    ) : CityModels(description,image)
}

