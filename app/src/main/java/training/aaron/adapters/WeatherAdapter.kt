package training.aaron.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import training.aaron.models.WeatherObject
import training.aaron.sunshine.R

/**
 * @author Aarón Negrete
 * Created by developer on 1/16/18.
 */
class WeatherAdapter(var data: ArrayList<WeatherObject>, var context: Context) : RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_weather_list,parent,false)
        var weatherHolder = WeatherHolder(view)
        view.setTag(weatherHolder)
        return weatherHolder
    }

    override fun onBindViewHolder(holder: WeatherHolder?, position: Int) {
        holder!!.txtDescription.setText("${data[position].mDescription}  ${data[position].mMaxtemperature}")
        Glide.with(context).load(data[position].mImagePath).into(holder.iconWeather)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class WeatherHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtDescription: TextView = itemView.findViewById(R.id.descriptionWeather)
        var iconWeather: ImageView = itemView.findViewById(R.id.iconweather)
    }
}