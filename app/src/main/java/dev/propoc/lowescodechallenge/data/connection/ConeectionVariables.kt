package dev.propoc.lowescodechallenge.data.connection

import dev.propoc.lowescodechallenge.data.api.ForeCastApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitProvider {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val APP_ID = "65d00499677e59496ca2f318eb68c049"
        val retrofit: Retrofit

        init {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val forecastService: ForeCastApi = retrofit.create(ForeCastApi::class.java)
}
