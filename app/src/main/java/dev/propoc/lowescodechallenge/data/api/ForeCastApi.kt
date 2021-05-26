package dev.propoc.lowescodechallenge.data.api

import dev.propoc.lowescodechallenge.domain.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ForeCastApi {
    @GET("forecast")
    suspend fun getForecastByCityCoroutine(
        @Query("appid") apiKey: String,
        @Query("q") city: String,
        @Query("units") units: String = "imperial"
    ): ForecastResponse
}
