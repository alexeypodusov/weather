package ru.alexey_podusov.weather.model

import io.reactivex.Observable
import io.realm.Realm
import ru.alexey_podusov.weather.toObservableFromArray

class MainService(var openWeatherMapService: OpenWeatherMapService) {
    fun getCitiesByQuery(query: String): Observable<List<CityRealm>> {
        val realm: Realm = Realm.getDefaultInstance()
        realm.use { realm ->
            if (query.isEmpty()) {
                //Получение избранных городов
                return realm.where(CityRealm::class.java)
                        .equalTo(CityRealm::isFavorite.name, true)
                        .findAll().toObservableFromArray()
            }
            return realm.where(CityRealm::class.java)
                    .like(CityRealm::name.name, "${query.toLowerCase()}*")
                    .findAll().toObservableFromArray()
        }
    }

}