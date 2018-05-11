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
import ru.alexey_podusov.weather.injection.Components
import ru.alexey_podusov.weather.model.FindResponse
import ru.alexey_podusov.weather.model.OpenWeatherMapService
import ru.alexey_podusov.weather.view.CityListView
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class CityListPresenter: MvpPresenter<CityListView>() {
    @Inject
    lateinit var openWeatherMapService: OpenWeatherMapService

    init {
        Components.get(javaClass)!!.inject(this)
    }

    fun subscribeQueryTextChangedObservable(observable: InitialValueObservable<CharSequence>) {
        observable
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .filter{ charSeq -> charSeq.length > 4  }
                .flatMap { queryCharSequence -> openWeatherMapService.findCity(StringBuilder(queryCharSequence).toString()) }
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ find -> find }, { error -> error })
    }
}