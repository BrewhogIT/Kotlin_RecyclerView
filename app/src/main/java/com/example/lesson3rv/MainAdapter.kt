package com.example.lesson3rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3rv.databinding.MainItemBinding

class MainAdapter(val onClick:(String)-> Unit):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var list= mutableListOf<MainModel>()
    set(value) {
        field=value
        notifyDataSetChanged()
    }

    class MainViewHolder(view: View):RecyclerView.ViewHolder(view){
        lateinit var binding: MainItemBinding
        constructor(b: MainItemBinding) : this(b.root) {
            binding = b
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val mainView = MainItemBinding.inflate(LayoutInflater.from(parent.context))
        return MainViewHolder(mainView)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
     holder.binding.nameText.text = list[position].name
     holder.binding.ageText.text = list[position].age.toString()

     holder.itemView.setOnClickListener {
     onClick(list[position].name)
        }
    }
}