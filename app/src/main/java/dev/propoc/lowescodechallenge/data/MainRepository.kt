package dev.propoc.lowescodechallenge.data

import dev.propoc.lowescodechallenge.data.api.ForeCastApi
import dev.propoc.lowescodechallenge.data.connection.RetrofitProvider.APP_ID

class MainRepository(private val apiService: ForeCastApi) {
    suspend fun getForecast(cityName: String) = apiService.getForecastByCityCoroutine(APP_ID, cityName)
}
