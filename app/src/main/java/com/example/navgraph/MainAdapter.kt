package com.example.navgraph

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navgraph.databinding.ItemCardBinding

class MainAdapter(val list:ArrayList<PersonModel>,val onClick:(personModel: PersonModel)-> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(private val binding: ItemCardBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(){
            val item = list[adapterPosition]
            binding.tv1.text = item.name
            binding.tv2.text = item.alive
            Glide.with(binding.iv1).load(item.image).into(binding.iv1)

            itemView.setOnClickListener {

            }
        }

    }

}
