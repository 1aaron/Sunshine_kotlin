package training.aaron.training.aaron.fragments

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.view.*
import training.aaron.adapters.WeatherAdapter
import training.aaron.models.WeatherObject
import training.aaron.network.NetworkUtilities
import training.aaron.sunshine.R

/**
 * @author Aarón Negrete
 * Created by developer on 1/16/18.
 */
class Main : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_main, container, false)

        var dummydata = arrayListOf<String>("dato 1","dato 2","dato 3","dato 4")
        var adapter = WeatherAdapter(dummydata,context)

        view.weatherList.layoutManager = LinearLayoutManager(context)
        view.weatherList.setHasFixedSize(true)
        view.weatherList.adapter = adapter

        var ednPoint = Uri.parse("http:((www.google.com").buildUpon()
                .appendPath("vistas2")
                .appendQueryParameter("username","Aarón")
                .appendQueryParameter("id","3")
                .build()


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NetworkUtilities.getWeatherData(context)

    }
}