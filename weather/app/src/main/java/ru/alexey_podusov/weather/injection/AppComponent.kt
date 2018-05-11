package ru.alexey_podusov.weather.injection

import dagger.Component
import ru.alexey_podusov.weather.CityListActivity
import ru.alexey_podusov.weather.presenter.CityListPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(cityListActivity: CityListActivity)
    fun inject(cityListPresenter: CityListPresenter)
}