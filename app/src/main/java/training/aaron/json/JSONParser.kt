package training.aaron.json

import org.json.JSONObject
import training.aaron.models.WeatherObject

/**
 * @author Aarón Negrete
 * Created by developer on 1/16/18.
 */
class JSONParser {
    companion object {
        fun getWeatherObjects(response: String) : ArrayList<WeatherObject>{
            val weatherObjects = ArrayList<WeatherObject>()
            val jsonObject = JSONObject(response)

            val list = jsonObject.getJSONArray("list")

            for (i in 0..(list.length()-1)){
                val currentObjct = list.getJSONObject(i)
                val temperature = currentObjct.getJSONArray("temp").getJSONObject(0)
                val minTemp = temperature.optDouble("min",0.0)
                val maxTemperature = temperature.optDouble("max",0.0)
                val descObject = currentObjct.getJSONObject("weather")
                val desc = descObject.optString("main","")

                weatherObjects.add(WeatherObject(minTemp,maxTemperature,desc))
            }
            return weatherObjects
        }
    }
}