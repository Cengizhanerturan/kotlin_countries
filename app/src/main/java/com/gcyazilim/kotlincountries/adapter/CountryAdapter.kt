package com.gcyazilim.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gcyazilim.kotlincountries.databinding.ItemCountryBinding
import com.gcyazilim.kotlincountries.model.Country
import com.gcyazilim.kotlincountries.view.FeedFragmentDirections

class CountryAdapter(private var countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {
    class CountryViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        //? Data Binding
        holder.binding.country = countryList[position]
        //? Data Binding ile Click islemi
        holder.binding.listener = this

        //? Data binding öncesi
        /*holder.binding.name.text = countryList[position].countryName
        holder.binding.region.text = countryList[position].countryRegion

        holder.itemView.setOnClickListener {
            val action =
                FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(holder.itemView).navigate(action)
        }

        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl)*/

    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(view: View) {
        val binding = DataBindingUtil.findBinding<ItemCountryBinding>(view)
        val uuid = binding?.country?.uuid ?: return
        val action =
            FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(view).navigate(action)
    }
}