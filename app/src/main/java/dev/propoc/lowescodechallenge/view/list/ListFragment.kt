package dev.propoc.lowescodechallenge.view.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dev.propoc.lowescodechallenge.R
import dev.propoc.lowescodechallenge.databinding.FragmentListBinding
import dev.propoc.lowescodechallenge.domain.model.Forecast
import dev.propoc.lowescodechallenge.util.Status
import dev.propoc.lowescodechallenge.view.list.vm.ListViewModel

class ListFragment: Fragment(), ForecastListAdapter.OnForecastEventListener {

    private val adapter: ForecastListAdapter = ForecastListAdapter(this)
    private lateinit var cityName: String
    private val args by navArgs<ListFragmentArgs>()
    private lateinit var binding: FragmentListBinding
    val viewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityName = args.cityName
        viewModel.searchCityWeather(cityName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.forecastRecycler.adapter = adapter
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.d("ListFragment", "Success")
                        adapter.submitList(resource.data?.list)
                    }
                    Status.ERROR -> {
                        findNavController().navigate(ListFragmentDirections.actionListFragmentToSearchFragment("Error"))
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    override fun onForecastSelected(forecast: Forecast) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(forecast))
    }
}
