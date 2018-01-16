package training.aaron.network

import android.content.Context
import android.net.Uri
import android.util.Log
import com.softwaremobility.network.Connection
import com.softwaremobility.simplehttp.NetworkConnection
import training.aaron.models.WeatherObject
import training.aaron.sunshine.R

/**
 * @author Aarón Negrete
 * Created by developer on 1/16/18.
 */
class NetworkUtilities {
    companion object {
        fun getWeatherData(context: Context){
            var endPoint = Uri.parse(context.getString(R.string.endPointWeatherList))
            var params = HashMap<String,String>()
            params.put(context.getString(R.string.paramFormat),"json")
            params.put(context.getString(R.string.paramDays),"14")
            params.put(context.getString(R.string.paramQuery),"45050")
            params.put(context.getString(R.string.paramUnits),"metric")
            params.put(context.getString(R.string.paramApiKey),context.getString(R.string.apiKey))

            val headers = HashMap<String, String>()
            headers.put("content-type","application/json")
            NetworkConnection.with(context).withListener(object: NetworkConnection.ResponseListener{
                override fun onSuccessfullyResponse(response: String?) {
                    Log.e("bien",response)
                }

                override fun onErrorResponse(error: String?, message: String?, code: Int) {
                    if(error != null)
                        Log.e("error",error)
                    else
                        Log.e("tag","error nulo")
                }
            }).doRequest(Connection.REQUEST.GET,endPoint,params,headers,null)
        }
    }
}