package ru.alexey_podusov.weather.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.alexey_podusov.weather.view.CityListView

@InjectViewState
class CityListPresenter: MvpPresenter<CityListView>() {
    fun search(query: String) {
        var i = 0
        i++
    }
}