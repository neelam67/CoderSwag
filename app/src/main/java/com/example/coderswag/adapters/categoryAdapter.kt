package com.example.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class categoryAdapter(var context: Context, var categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int,convertView: View?, parent: ViewGroup?): View {

        var holder: ViewHolder
        val categoryView: View

        if(convertView == null){
          categoryView  =
                LayoutInflater.from(context).inflate(R.layout.categories_list_item, null)
            holder= ViewHolder()
            holder.categoryTextView = categoryView.findViewById(R.id.tv_category)
            holder.categoryImageView = categoryView.findViewById(R.id.iv_item)

            categoryView.tag = holder

            println("for position $position layout inflated")
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("for position $position layout recycled!")
        }

        val categoryObj : Category = categories.get(position)

       holder.categoryTextView?.text = categoryObj.title

        val resourceIDImageView = context.resources.getIdentifier(
            categoryObj.image, "drawable", context.packageName
        )
        holder.categoryImageView?.setImageResource(resourceIDImageView)

        return categoryView
    }

    override fun getItem(position: Int): Any {
       return categories.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }
}

private class ViewHolder{
    var categoryImageView : ImageView? = null
    var categoryTextView : TextView? = null
}