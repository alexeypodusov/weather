package ru.alexey_podusov.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import ru.alexey_podusov.weather.injection.Components

class CityListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Components.get(javaClass)!!.inject(this)
        setContentView(R.layout.activity_main)
     }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_city_list, menu)
        val searchView = menu!!.findItem(R.id.menu_item_search).actionView as SearchView
        searchView.isIconified = false
//        val searchAutoCompleteTextView = searchView.findViewById<AutoCompleteTextView>(resources.getIdentifier("search_src_text", "id", packageName))
//        searchAutoCompleteTextView.isFocusable = false
        return true
    }
}
