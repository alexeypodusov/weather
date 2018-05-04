package ru.alexey_podusov.weather.presenter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import org.reactivestreams.Subscription

class BasePresenter<View : MvpView> : MvpPresenter<View>() {
//    private val compositeSubscription = CompositeSubscription()
//
//    protected fun unsubscribeOnDestroy(subscription: Subscription) {
//        compositeSubscription.add(subscription)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        compositeSubscription.clear()
//    }
}