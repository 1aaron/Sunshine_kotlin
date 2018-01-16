package training.aaron.json

import android.content.Context
import org.json.JSONObject
import training.aaron.models.WeatherObject
import training.aaron.sunshine.R

/**
 * @author Aarón Negrete
 * Created by developer on 1/16/18.
 */
class JSONParser {
    companion object {
        fun getWeatherObjects(context: Context, response: String) : ArrayList<WeatherObject>{
            val weatherObjects = ArrayList<WeatherObject>()
            val jsonObject = JSONObject(response)

            val list = jsonObject.getJSONArray("list")

            for (i in 0..(list.length()-1)){
                val currentObjct = list.getJSONObject(i)
                val dateTime = currentObjct.optLong("dt",0)
                val temperature = currentObjct.getJSONObject("temp")
                val minTemp = temperature.optDouble("min",0.0)
                val maxTemperature = temperature.optDouble("max",0.0)
                val descObject = currentObjct.getJSONArray("weather")
                val desc = descObject.getJSONObject(0).optString("main","")
                var image = descObject.getJSONObject(0).optString("icon","")
                image = context.getString(R.string.urlImages,image)
                weatherObjects.add(WeatherObject(minTemp,maxTemperature,desc,image,dateTime))
            }
            return weatherObjects
        }
    }
}