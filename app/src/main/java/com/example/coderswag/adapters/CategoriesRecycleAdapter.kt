package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.model.Category
import kotlinx.android.synthetic.main.categories_list_item.view.*

class CategoriesRecycleAdapter(var context: Context, var categoryObj: List<Category>, var itemClick : (Category) -> Unit) : RecyclerView.Adapter<CategoriesRecycleAdapter.holder>() {

    //view holder class
    inner class holder(itemView: View, itemClick : (Category) -> Unit) : RecyclerView.ViewHolder(itemView){

        var categoryImageView = itemView.findViewById<ImageView>(R.id.iv_item)
        var categoryTextView = itemView.findViewById<TextView>(R.id.tv_category)

        fun bindDataToView(categoryObj: Category, context: Context){
            categoryTextView?.text = categoryObj.title

            val resourceIDImageView = context.resources.getIdentifier(
                categoryObj.image, "drawable", context.packageName
            )
           categoryImageView?.setImageResource(resourceIDImageView)

            itemView.setOnClickListener{itemClick(categoryObj)}


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val categoryView = LayoutInflater.from(context).inflate(
            R.layout.categories_list_item, parent, false
        )

        return holder(categoryView, itemClick)
    }

    override fun getItemCount(): Int {
        return categoryObj.count()
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder?.bindDataToView(categoryObj.get(position), context)
    }

}