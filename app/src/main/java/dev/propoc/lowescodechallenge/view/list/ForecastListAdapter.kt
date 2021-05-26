package dev.propoc.lowescodechallenge.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.propoc.lowescodechallenge.databinding.WeatherListItemBinding
import dev.propoc.lowescodechallenge.domain.model.Forecast

class ForecastListAdapter(
    private val listener: OnForecastEventListener?
): ListAdapter<Forecast, ForecastListAdapter.ForecastVH>(ForecastDiff()) {
    interface OnForecastEventListener {
        fun onForecastSelected(forecast: Forecast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastVH {
        return ForecastVH(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ForecastVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ForecastVH(private val itemBinding: WeatherListItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        init {
            itemBinding.root.setOnClickListener {
                itemBinding.forecast?.let {
                    listener?.onForecastSelected(it)
                }
            }
        }
        fun bind(forecast: Forecast){
            itemBinding.forecast = forecast
            itemBinding.view.visibility = if(adapterPosition == currentList.size - 1) View.INVISIBLE else View.VISIBLE
        }
    }
}

class ForecastDiff: DiffUtil.ItemCallback<Forecast>(){
    override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem.timeForecastMillis == newItem.timeForecastMillis
    }

    override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }
}