package training.aaron.models

/**
 * Created by developer on 1/16/18.
 */
class WeatherObject(minTemperature: Double, maxTemperature: Double, description: String, imagePath: String, dateTime: Long){
    var mMinTemperature = minTemperature
    var mMaxtemperature = maxTemperature
    var mDescription = description
    var mImagePath = imagePath
    var mDateTime: Long = dateTime
}