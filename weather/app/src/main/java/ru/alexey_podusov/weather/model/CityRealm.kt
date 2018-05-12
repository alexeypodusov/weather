package ru.alexey_podusov.weather.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class CityRealm: RealmObject() {
    @PrimaryKey
    var id: Long = 0

    lateinit var name: String
    var openWeatherId: Long = 0

}