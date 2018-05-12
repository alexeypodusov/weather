package ru.alexey_podusov.weather.model

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface OpenWeatherMapApi {
    @GET("find")
    fun findCity(@Query("q") query: String, @Query("appid") appid: String): Call<FindResponse>
}