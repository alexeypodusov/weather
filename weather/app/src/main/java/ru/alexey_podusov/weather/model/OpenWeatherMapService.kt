package ru.alexey_podusov.weather.model

import io.reactivex.Observable
import java.util.*


class OpenWeatherMapService(var api: OpenWeatherMapApi) {
    companion object {
        val APP_ID = "6d65818114125635e90a6747fad8b62a"
    }

    fun findCity(query: String): Observable<FindResponse> {
        return api.findCity(query, APP_ID)
    }
}