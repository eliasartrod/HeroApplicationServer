package com.heroserver.di

import com.heroserver.repository.HeroRepository
import com.heroserver.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    //Injecting HeroRepository Implementation
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}