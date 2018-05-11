package ru.alexey_podusov.weather.model

class City {
    data class Main(var temp: Double,
                    var pressure: Double,
                    var humidity: Double,
                    var temp_min: Double,
                    var temp_max: Double)

    data class Sys(var country: String)

    var id = 0
    lateinit var name: String
    lateinit var main: Main
    lateinit var sys: Sys
}
