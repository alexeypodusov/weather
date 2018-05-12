package ru.alexey_podusov.weather

import android.app.Application
import android.content.ContentValues
import io.realm.Realm
import ru.alexey_podusov.weather.injection.AppComponent
import ru.alexey_podusov.weather.injection.AppModule
import ru.alexey_podusov.weather.injection.DaggerAppComponent
import ru.alexey_podusov.weather.model.CityRealmObject
import java.io.BufferedReader
import java.io.InputStreamReader

class WeatherApp : Application() {
    companion object {
        val FILE_CITY_LIST = "listCity.txt"
        val CP1251 = "windows-1251"

        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        Realm.init(this)

        val realm = Realm.getDefaultInstance()
        if (realm.where(CityRealmObject::class.java).findFirst() == null) {
            loadCitiesFromFileInRealm(realm)
        }
    }

    private fun loadCitiesFromFileInRealm(realm: Realm) {
        val assetManager = assets
        val inputStream = InputStreamReader(assetManager.open(FILE_CITY_LIST), CP1251)
        val  bufferedReader = BufferedReader(inputStream)
        bufferedReader.readLine()

        realm.beginTransaction()
        while(true) {
            val cityName = bufferedReader.readLine() ?: return
            val cityRealmObject = CityRealmObject()
            cityRealmObject.name = cityName
            //realm.insertOrUpdate(cityRealmObject)
        }
        realm.commitTransaction()
    }

}
