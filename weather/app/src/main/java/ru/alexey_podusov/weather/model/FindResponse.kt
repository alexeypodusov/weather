package ru.alexey_podusov.weather.model

class FindResponse {
    lateinit var message: String
    lateinit var code: String
    var count = 0
    lateinit var list: ArrayList<City>

}