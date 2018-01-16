package training.aaron.training.aaron.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softwaremobility.network.Connection
import com.softwaremobility.simplehttp.NetworkConnection
import kotlinx.android.synthetic.main.fragment_main.*
import training.aaron.adapters.WeatherAdapter
import training.aaron.json.JSONParser
import training.aaron.models.WeatherObject
import training.aaron.sunshine.R

/**
 * @author Aarón Negrete
 * Created by developer on 1/16/18.
 */
class Main : Fragment() {

    var data = ArrayList<WeatherObject>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getWeatherData()
    }

    fun getWeatherData(){
        var endPoint = Uri.parse(context!!.getString(R.string.endPointWeatherList))
        var params = HashMap<String,String>()
        params.put(getString(R.string.paramFormat),"json")
        params.put(getString(R.string.paramDays),"14")
        params.put(getString(R.string.paramQuery),"45050")
        params.put(getString(R.string.paramUnits),"metric")
        params.put(getString(R.string.paramApiKey),context!!.getString(R.string.apiKey))

        val headers = HashMap<String, String>()
        headers.put("content-type","application/json")
        NetworkConnection.with(context).withListener(object: NetworkConnection.ResponseListener{
            override fun onSuccessfullyResponse(response: String?) {
                data = JSONParser.getWeatherObjects(context!!,response!!)
                updateUI()
            }

            override fun onErrorResponse(error: String?, message: String?, code: Int) {
                if(error != null)
                    Log.e("error",error)
                else
                    Log.e("tag","error nulo")
            }
        }).doRequest(Connection.REQUEST.GET,endPoint,params,headers,null)
    }
    fun updateUI(){

        var adapter = WeatherAdapter(data,context!!)
        weatherList.layoutManager = LinearLayoutManager(context)
        weatherList.setHasFixedSize(true)
        weatherList.adapter = adapter
    }
}