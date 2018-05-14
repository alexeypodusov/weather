package ru.alexey_podusov.weather


import android.app.Application
import io.realm.Realm
import ru.alexey_podusov.weather.injection.AppComponent
import ru.alexey_podusov.weather.injection.AppModule
import ru.alexey_podusov.weather.injection.DaggerAppComponent
import ru.alexey_podusov.weather.model.CityRealm
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
        Realm.init(this)
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        checkAndLoadCitiesFromFileToDatabase()
    }

    private fun checkAndLoadCitiesFromFileToDatabase() {
        val realm = Realm.getDefaultInstance()
        realm.use { realm ->
            if (realm.where(CityRealm::class.java).findFirst() == null) {
                val assetManager = assets
                val inputStream = InputStreamReader(assetManager.open(FILE_CITY_LIST), CP1251)
                val bufferedReader = BufferedReader(inputStream)

                realm.beginTransaction()
                var primaryKey: Long = 0
                while (true) {
                    val cityName = bufferedReader.readLine() ?: break
                    val cityRealm = CityRealm()
                    cityRealm.name = cityName.toLowerCase()
                    cityRealm.id = primaryKey
                    primaryKey++
                    realm.insertOrUpdate(cityRealm)
                }
                realm.commitTransaction()
            }
        }
    }

}
