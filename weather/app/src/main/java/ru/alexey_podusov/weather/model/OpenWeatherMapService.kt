package ru.alexey_podusov.weather.model

import android.app.Application
import io.reactivex.Observable
import java.util.*


class OpenWeatherMapService(var api: OpenWeatherMapApi) {
    companion object {
        val APP_ID = "6d65818114125635e90a6747fad8b62a"
    }

    fun findCity(query: String) {
        if (!query.isEmpty()) {
            val response = api.findCity(query, APP_ID).execute() ?: throw Exception()
           // if (response.body()?.code)
        }
        //return Observable.fromCallable { on }(api.findCity(query, APP_ID))
    }
}