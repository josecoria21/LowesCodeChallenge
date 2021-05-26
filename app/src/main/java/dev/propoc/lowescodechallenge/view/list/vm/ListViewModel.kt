package dev.propoc.lowescodechallenge.view.list.vm

import androidx.lifecycle.*
import dev.propoc.lowescodechallenge.data.MainRepository
import dev.propoc.lowescodechallenge.data.connection.RetrofitProvider
import dev.propoc.lowescodechallenge.domain.model.ForecastResponse
import dev.propoc.lowescodechallenge.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(): ViewModel() {

    private val _response = MutableLiveData<Resource<ForecastResponse>>()
    val response: LiveData<Resource<ForecastResponse>> get() = _response
    private val mainRepository: MainRepository = MainRepository(RetrofitProvider.forecastService)

    fun searchCityWeather(cityName: String) {
        _response.value = Resource.loading(data = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _response.postValue(Resource.success(data = mainRepository.getForecast(cityName)))
            } catch (exception: Exception) {
                _response.postValue(Resource.error(data = null, message = exception.message ?: "There was an error"))
            }
        }
    }
}