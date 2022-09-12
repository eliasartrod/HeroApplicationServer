package com.heroserver.models

import kotlinx.serialization.Serializable

//In order to send an object as a response we need to be able to convert them as a Json.
@Serializable
data class ApiResponse (
    val success: Boolean,
    val message: String? = null,
    //Paginating
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList()
)