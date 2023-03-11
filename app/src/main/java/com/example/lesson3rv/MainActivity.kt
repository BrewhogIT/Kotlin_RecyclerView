package com.example.lesson3rv

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson3rv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val adapter=MainAdapter(this::onItemClick)
    lateinit var binding: ActivityMainBinding
    private val list= mutableListOf<MainModel>()
    private val nameList= arrayOf("Vasya","Petya", "Masha", "Olga","Kiril")
    private val ageList= arrayOf(18,34,65,17,7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
             binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        createList()
    }

    private fun onItemClick(text:String) {
        Toast.makeText(this,"Click on "+text,Toast.LENGTH_LONG).show()
           }

    private fun createList() {
        for (i in 0 ..4){
            list.add(MainModel(nameList[i],ageList[i]))
        }

        adapter.list=list
    }

    private fun initAdapter() {
       binding.rv.adapter=adapter
       binding.rv.layoutManager=LinearLayoutManager(this)
    }
}