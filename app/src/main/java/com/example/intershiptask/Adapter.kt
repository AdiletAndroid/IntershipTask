package com.example.intershiptask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intershiptask.databinding.ItemRecyclerBinding

class Adapter(private val onItemClick: (Model) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val dataList = mutableListOf<Model>()

    fun showData(data: List<Model>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = dataList[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(private val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val model = dataList[position]
                    onItemClick.invoke(model)
                }
            }
        }

        fun bind(model: Model) {
            Glide.with(binding.imageView)
                .load(model.image)
                .into(binding.imageView)

            binding.nameTextView.text = model.name
            binding.yearTextView.text = model.year.toString()
        }
    }
}



