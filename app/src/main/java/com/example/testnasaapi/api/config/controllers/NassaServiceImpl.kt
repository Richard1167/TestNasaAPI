package com.example.testnasaapi.api.config.controllers

import com.example.testnasaapi.api.retrofit.INasa
import com.example.testnasaapi.api.retrofit.getRetrofit

class NasaServiceImpl {

    fun getNasaPlanetaryApod() = try {
        Pair(
            getRetrofit().create(INasa::class.java).getNasaPlanetaryApod().execute().body(), null
        )
    } catch (e: java.lang.Exception) {
        Pair(null, e)
    }

    fun getNasaPlanetaryEarth() = try {
        Pair(
            getRetrofit().create(INasa::class.java).getNasaPlanetaryEarth().execute().body(), null
        )
    } catch (e: java.lang.Exception) {
        Pair(null, e)
    }

    fun getNasaPhotoMars() = try {
        Pair(
            getRetrofit().create(INasa::class.java).getNasaPlanetaryPhotoMars().execute().body(),null
        )
    }   catch (e: java.lang.Exception){
        Pair(null, e)
    }

}