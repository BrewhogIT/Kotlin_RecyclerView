package com.example.lesson3rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val onClick:(String)-> Unit):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var list= mutableListOf<String>()
    set(value) {
        field=value
        notifyDataSetChanged()

    }




 //   fun setList(list: MutableList<String>){
  //      this.list=list
  //  }

    class MainViewHolder(view: View):RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.main_item,parent,false)

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

     val myText=  holder.itemView.findViewById<TextView>(R.id.txt_item)

       myText.text=list[position]
   holder.itemView.setOnClickListener {

       onClick(list[position])

   }





    }




}