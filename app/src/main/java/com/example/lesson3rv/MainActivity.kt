package com.example.lesson3rv

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson3rv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val adapter=MainAdapter(this::onItemClick)


    lateinit var binding: ActivityMainBinding
    private val list= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
             binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        createList()
    }


    private fun onItemClick(text:String) {

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()


    }




    private fun createList() {

        for (i in 1 ..5){
            list.add("What time is it: now ${i} o'clock")
        }


        adapter.list=list

    }

    private fun initAdapter() {
       binding.rv.adapter=adapter
       binding. rv.layoutManager=GridLayoutManager(this,3)
    }
}