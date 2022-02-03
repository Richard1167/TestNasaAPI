package com.example.testnasaapi.api.retrofit


import androidx.annotation.LongDef
import com.example.testnasaapi.models.NasaPlanetaryApodData
import com.example.testnasaapi.models.NasaPlanetaryEarthData
import com.example.testnasaapi.models.NasaPlanetaryPhotoMarsa

import com.example.testnasaapi.models.Stub
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface INasa {

    @GET("planetary/apod")
    fun getNasaPlanetaryApod(
        @Query("api_key") key: String = "68Rq5FWI15tpF72RSY4e3GkEtwNYSWmIhPIiKYRf"
    ): Call<NasaPlanetaryApodData>

    @GET("planetary/earth/assets")
    fun getNasaPlanetaryEarth(
        @Query("api_key") key: String = "68Rq5FWI15tpF72RSY4e3GkEtwNYSWmIhPIiKYRf",
        @Query("lon") lon: String = "-95.33",
        @Query("lat") lat: String = "29.78",
        @Query("date") date: String = "2018-01-01",
        @Query("dim") dim: String = "0.10"
    ): Call<NasaPlanetaryEarthData>

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getNasaPlanetaryPhotoMars(
        @Query("api_key") key: String = "68Rq5FWI15tpF72RSY4e3GkEtwNYSWmIhPIiKYRf",
        @Query("earth_date") earth_date: String = "2015-6-3",
    ): Call<NasaPlanetaryPhotoMarsa>


}