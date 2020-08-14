package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Product
import kotlinx.android.synthetic.main.products_list_item.view.*
import org.w3c.dom.Text

class ProductRecyclerAdapter(var context: Context, var productList : List<Product>, var productClick: (Product) -> Unit) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View, productViewClick : (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {

        var productImageView = itemView.findViewById<ImageView>(R.id.iv_Product)
        var productTextTitle = itemView.findViewById<TextView>(R.id.tv_product_name)
        var productTextPrice = itemView.findViewById<TextView>(R.id.tv_product_amount)

        fun bindProductDataToHolder(context: Context, productObj : Product){
            productTextTitle.text = productObj.title
            productTextPrice.text = productObj.price

            var imageResourceId = context.resources.getIdentifier(productObj.image, "drawable", context.packageName)
            productImageView.setImageResource(imageResourceId)

            itemView.setOnClickListener{
                productClick(productObj)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var ProductView = LayoutInflater.from(context).inflate(
                R.layout.products_list_item, parent, false
        )

        return ProductViewHolder(ProductView, productClick)
    }

    override fun getItemCount(): Int {
        return productList.count()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProductDataToHolder(context, productList.get(position))
    }

}