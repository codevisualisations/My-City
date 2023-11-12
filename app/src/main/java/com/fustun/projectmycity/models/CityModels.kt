package com.fustun.projectmycity.models

sealed class CityModels(
    open val name : Int,
    open val image : Int,
){
    data class Continent(
        override val name : Int,
        override val image: Int,
    ) : CityModels(name,image)

    data class Cities(
        override  val name: Int,
        override  val image: Int,
    ) : CityModels(name,image)

    data class Attractions(
        override val name: Int,
        val description: Int,
        override val image:Int,
    ) : CityModels(name,image)
}

