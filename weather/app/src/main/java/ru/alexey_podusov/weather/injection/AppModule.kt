package ru.alexey_podusov.weather.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexey_podusov.weather.model.MainService
import ru.alexey_podusov.weather.model.OpenWeatherMapApi
import ru.alexey_podusov.weather.model.OpenWeatherMapService
import javax.inject.Singleton

@Module
class AppModule(var mContext: Context) {
    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    }

    @Provides
    fun provideContext(): Context {
        return mContext
    }

    @Provides
    @Singleton
    fun provideOpenWeatherMapService(openWeatherMapApi: OpenWeatherMapApi): OpenWeatherMapService {
        return OpenWeatherMapService(openWeatherMapApi)
    }

    @Provides
    @Singleton
    fun provideOpenWeatherMapApi(retrofit: Retrofit): OpenWeatherMapApi {
        return retrofit.create(OpenWeatherMapApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMainService(openWeatherMapService: OpenWeatherMapService): MainService {
        return MainService(openWeatherMapService)
    }


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}