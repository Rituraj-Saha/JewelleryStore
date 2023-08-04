package com.techmasan.jewellerystore.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techmasan.jewellerystore.R
import com.techmasan.jewellerystore.adaptor.CategoryAdaptor
import com.techmasan.jewellerystore.databinding.ActivityHomeBinding
import com.techmasan.jewellerystore.models.Category


class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        var catList = ArrayList<Category>();
        catList.add(Category(1,"Neckless",""))
        catList.add(Category(1,"Neckless",""))
        catList.add(Category(1,"Neckless",""))
        catList.add(Category(1,"Neckless",""))

        var layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        binding.appbarLayout.recyclCatNav.layoutManager = layoutManager
        binding.appbarLayout.recyclCatNav.adapter = CategoryAdaptor(catList)
        binding.appbarLayout.recyclCatNav.setHasFixedSize(true)

    }

}