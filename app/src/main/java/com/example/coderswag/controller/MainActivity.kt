package com.example.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.adapters.CategoriesRecycleAdapter
import com.example.coderswag.adapters.categoryAdapter
import com.example.coderswag.model.Category
import com.example.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var categoryAdapter : CategoriesRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CategoriesListView.adapter = CategoriesRecycleAdapter(this, DataService.categories){
           category ->
            var intentActivity = Intent(applicationContext, ProductsActivity::class.java)
            intentActivity.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(intentActivity)
//            Toast.makeText(this, "You clicked on ${category.title}", Toast.LENGTH_LONG).show()


        }


        //for listView
       /*CategoriesListView.setOnItemClickListener { adapterView, view, i, l ->
           val category = DataService.categories.get(i)

           Toast.makeText(this, "You clicked on ${category.title}", Toast.LENGTH_LONG).show()
       }*/

        CategoriesListView.layoutManager = LinearLayoutManager(this)
        CategoriesListView.setHasFixedSize(true)

    }


}