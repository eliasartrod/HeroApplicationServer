package com.heroserver.repository

import com.heroserver.models.ApiResponse
import com.heroserver.models.Hero

interface HeroRepository {

    val heroes: Map<Int, List<Hero>>

    val pageOne: List<Hero>
    val pageTwo: List<Hero>
    val pageThree: List<Hero>
    val pageFour: List<Hero>
    val pageFive: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): ApiResponse
    suspend fun searchAllHeroes(name: String?): ApiResponse

}