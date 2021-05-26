package dev.propoc.lowescodechallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Forecast(
    @SerializedName("dt") val timeForecastMillis: Long,
    @SerializedName("main") val mainData: Main,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("pop") val probPrecipitation: Double,
    @SerializedName("rain") val rain: Rain,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("dt_txt") val timeForecastString: String //format (UTC): yyyy-MM-dd HH:mm:ss

):Parcelable {
    @Parcelize
    data class Main(
        val temp: Double,
        val feels_like: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Int,
        val sea_level: Int,
        val grnd_level: Int,
        val humidity: Int,
        val temp_kf: Double
    ): Parcelable

    @Parcelize
    data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    ): Parcelable

    @Parcelize
    data class Clouds(
        val all: Int
    ): Parcelable

    @Parcelize
    data class Wind(
        val speed: Double,
        val deg: Int
    ): Parcelable

    @Parcelize
    data class Rain(
        @SerializedName("3h") val volume3hr: Double
    ): Parcelable

    @Parcelize
    data class Sys(
        val pod: String
    ): Parcelable

}