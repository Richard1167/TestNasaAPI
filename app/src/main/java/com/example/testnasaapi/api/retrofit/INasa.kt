package com.example.testnasaapi.api.retrofit


import com.example.testnasaapi.models.NasaPlanetaryApodData

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

//    @GET("planetary/earth")
//    fun getNasaPlanetaryEarth(
//        @Query("api_key") key: String = "68Rq5FWI15tpF72RSY4e3GkEtwNYSWmIhPIiKYRf"
//    ): Call<NasaPlanetaryEarth>


}