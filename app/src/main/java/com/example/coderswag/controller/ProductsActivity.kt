package com.example.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.adapters.ProductRecyclerAdapter
import com.example.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var ProductListAdapter : ProductRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        var categoryName = intent.getStringExtra(EXTRA_CATEGORY)

        Toast.makeText(this, "categoryName is $categoryName", Toast.LENGTH_LONG).show()

        ProductListAdapter = ProductRecyclerAdapter(this, DataService.getProducts(categoryName)) {
            product -> Toast.makeText(this, "Selected product is ${product.title}", Toast.LENGTH_SHORT).show()
        }

        ProductsListView.adapter = ProductListAdapter
        ProductsListView.layoutManager = GridLayoutManager(this ,2)

    }
}