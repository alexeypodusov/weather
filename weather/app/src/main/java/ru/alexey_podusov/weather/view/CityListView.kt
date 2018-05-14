package ru.alexey_podusov.weather.view

import com.arellomobile.mvp.MvpView
import ru.alexey_podusov.weather.model.CityRealm

interface CityListView: MvpView {
    fun showCities(cities: List<CityRealm>)
}