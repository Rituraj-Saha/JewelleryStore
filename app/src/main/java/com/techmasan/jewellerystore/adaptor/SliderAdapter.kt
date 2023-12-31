package com.techmasan.jewellerystore.adaptor

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso
import com.techmasan.jewellerystore.R
import com.techmasan.jewellerystore.models.SliderItemModel
import java.util.logging.Logger

class SliderAdapter(private val mList: ArrayList<SliderItemModel>,private val viewPager2: ViewPager2):RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    lateinit var _mList:ArrayList<SliderItemModel>
    init {
        this._mList=mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slide_item_container,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        Log.d("imageString",itemsViewModel.img);
        Picasso.get().load(itemsViewModel.img).into(holder.imageView);
        if (position == mList.size- 2){
            viewPager2.post(run);
        }
        //holder.imageView.setImageURI(itemsViewModel.img.toUri());
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: RoundedImageView = itemView.findViewById(R.id.imageSlide)
    }

    val run = object : Runnable {
        override fun run() {
            _mList.addAll(mList);
            notifyDataSetChanged();
        }
    }

}
