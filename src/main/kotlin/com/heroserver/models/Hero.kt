package com.heroserver.models

import kotlinx.serialization.Serializable

//In order to send an object as a response we need to be able to convert them as a Json
@Serializable
data class Hero (
    val id: Int,
    val power: Int,
    val rating: Double,
    val name: String,
    val image: String,
    val about: String,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)