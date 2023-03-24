package com.jecruzv.dogapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jecruzv.dogapi.databinding.BreedItemBinding

class PartAdapter (var partItemList: List<Breeds>, private val clickListener: (Breeds) -> Unit) :
RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = BreedItemBinding.inflate(inflater, parent, false)
        return PartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(partItemList[position], clickListener)
    }

    override fun getItemCount() = partItemList.size

    inner class PartViewHolder(private val binding: BreedItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(breed: Breeds, clickListener: (Breeds) -> Unit) {
            binding.tvPartItemName.text = breed.status
            binding.root.setOnClickListener { clickListener(breed) }
        }
    }
}