package ru.alexey_podusov.weather.presenter

import android.util.AndroidException
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.jakewharton.rxbinding2.InitialValueObservable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription
import ru.alexey_podusov.weather.WeatherApp
import ru.alexey_podusov.weather.injection.Components
import ru.alexey_podusov.weather.model.FindResponse
import ru.alexey_podusov.weather.model.MainService
import ru.alexey_podusov.weather.model.OpenWeatherMapService
import ru.alexey_podusov.weather.view.CityListView
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class CityListPresenter : BasePresenter<CityListView>() {
    @Inject
    lateinit var mainService: MainService

    init {
        WeatherApp.appComponent.inject(this)
    }

    fun subscribeQueryTextChangedObservable(observable: InitialValueObservable<CharSequence>) {
        unsubscribeOnDestroy(
                observable
                        .debounce(300, TimeUnit.MILLISECONDS)
                        .distinctUntilChanged()
                        .flatMap { queryCharSequence -> mainService.getCitiesByQuery(StringBuilder(queryCharSequence).toString()) }
                        .observeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe{ cities -> viewState.showCities(cities) })
    }
}