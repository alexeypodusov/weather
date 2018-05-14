package ru.alexey_podusov.weather

import io.reactivex.Observable
import io.realm.RealmResults

fun <T>RealmResults<T>.toObservableFromArray(): Observable<List<T>> {
    val arrayList = ArrayList<T>()
    forEach { arrayList.add(it) }
    return Observable.fromArray(arrayList)
}