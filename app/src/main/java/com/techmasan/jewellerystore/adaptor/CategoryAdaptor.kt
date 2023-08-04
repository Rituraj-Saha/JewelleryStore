package com.techmasan.jewellerystore.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.techmasan.jewellerystore.R
import com.techmasan.jewellerystore.databinding.ItemCategoryBinding
import com.techmasan.jewellerystore.models.Category


class CategoryAdaptor(private val mList: ArrayList<Category>):RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {

    lateinit var binding:ItemCategoryBinding
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var imgCat:ImageView = itemView.findViewById(R.id.imgCat)
        var txtCatName:TextView = itemView.findViewById(R.id.txtCatName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryAdaptor.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var data = mList[position]
        holder.txtCatName.text = data.name
    }
}