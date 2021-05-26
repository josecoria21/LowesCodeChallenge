package dev.propoc.lowescodechallenge.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    val id: Int = -1,
    val name: String = "",
    val coord: Coordinates = Coordinates(),
    val country: String = "",
    val timezone: Int = 0,
    val population: Long = 0,
    val sunrise: Long = 0,
    val sunset: Long = 0
): Parcelable {
    @Parcelize
    data class Coordinates(
        val lat: Double = 0.0,
        val lon: Double = 0.0
    ): Parcelable
}