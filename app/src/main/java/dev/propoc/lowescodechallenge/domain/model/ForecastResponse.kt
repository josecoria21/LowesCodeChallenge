package dev.propoc.lowescodechallenge.domain.model

import android.os.Parcelable
import dev.propoc.lowescodechallenge.data.api.ApiResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ForecastResponse(
    val cnt: Int = 0,
    val list: List<Forecast> = emptyList(),
    val city: City = City()
): Parcelable, ApiResponse {
    override val cod: String = "200"
    override val message: Any = 0
}
