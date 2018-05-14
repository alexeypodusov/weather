package ru.alexey_podusov.weather

import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView
import ru.alexey_podusov.weather.injection.Components
import ru.alexey_podusov.weather.model.CityRealm
import ru.alexey_podusov.weather.presenter.CityListPresenter
import ru.alexey_podusov.weather.view.CityListView

class CityListActivity : MvpAppCompatActivity(), CityListView {
    @InjectPresenter
    lateinit var mCityListPresenter: CityListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApp.appComponent.inject(this)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_city_list, menu)
        val searchView = menu!!.findItem(R.id.menu_item_search).actionView as SearchView
        searchView.isIconified = false
        mCityListPresenter.subscribeQueryTextChangedObservable(RxSearchView.queryTextChanges(searchView))

        //RxSearchView.queryTextChanges(searchView).subscribe({str -> mCityListPresenter.search(String.toString())})
//        val searchAutoCompleteTextView = searchView.findViewById<AutoCompleteTextView>(resources.getIdentifier("search_src_text", "id", packageName))
//        searchAutoCompleteTextView.isFocusable = false
        return true
    }

    override fun showCities(cities: List<CityRealm>) {
        val i = 5+2
    }
}
