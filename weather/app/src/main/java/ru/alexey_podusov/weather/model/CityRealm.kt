package ru.alexey_podusov.weather.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CityRealm : RealmObject() {
    @PrimaryKey
    open var id: Long = 0

    open var name: String = ""
    open var openWeatherId: Long = 0
    open var isFavorite = false
}