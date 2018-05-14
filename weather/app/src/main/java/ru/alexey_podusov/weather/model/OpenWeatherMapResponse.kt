package ru.alexey_podusov.weather.model

data class FindResponse(
  var message: String,
    var code: String,
    var count: Int,
    var list: ArrayList<City>)

data class City(
    var id: Long,
    var name: String,
    var main: Main,
    var sys: Sys
)

data class Sys(var country: String)

data class Main(var temp: Double,
                var pressure: Double,
                var humidity: Double,
                var temp_min: Double,
                var temp_max: Double)