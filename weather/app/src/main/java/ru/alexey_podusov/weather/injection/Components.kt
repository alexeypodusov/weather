package ru.alexey_podusov.weather.injection

import java.util.*

class Components {
    companion object {
        val components = WeakHashMap<Any, AppComponent>()

        fun <T>get(cls: Class<T>) : AppComponent? {
            var component = components[cls]
            if (component == null) {
                //component = DaggerAppComponent.builder().appModule(AppModule()).build()
                components[cls] = component
            }
            return component
        }
    }
}