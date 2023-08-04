package com.techmasan.jewellerystore.pages

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.techmasan.jewellerystore.adaptor.SliderAdapter
import com.techmasan.jewellerystore.databinding.ActivityLandingBinding
import com.techmasan.jewellerystore.models.SliderItemModel


class LandingActivity : AppCompatActivity() {

    lateinit var binding: ActivityLandingBinding;
    private val sliderHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        val sliderItems = ArrayList<SliderItemModel>()
        sliderItems.add(SliderItemModel("https://source.unsplash.com/user/c_v_r/200x300"))
        sliderItems.add(SliderItemModel("https://source.unsplash.com/user/c_v_r/200x100"))
        sliderItems.add(SliderItemModel("https://source.unsplash.com/user/c_v_r/200x300"))
        sliderItems.add(SliderItemModel("https://source.unsplash.com/user/c_v_r/200x300"))
        sliderItems.add(SliderItemModel("https://source.unsplash.com/user/c_v_r/200x300"))
        binding.viewPagerImageSlider.adapter = SliderAdapter(sliderItems,binding.viewPagerImageSlider)

        binding.viewPagerImageSlider.setClipToPadding(false);
        binding.viewPagerImageSlider.setClipChildren(false);
        binding.viewPagerImageSlider.setOffscreenPageLimit(3);
        binding.viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

         var compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer( MarginPageTransformer(40));
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
           var r = 1 - Math.abs(position)
            page.setScaleY(0.85f + r * 0.15f);
        })

        binding.viewPagerImageSlider.setPageTransformer(compositePageTransformer);


        binding.viewPagerImageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                super.onPageSelected(position)
                sliderHandler.removeCallbacks(run);
                sliderHandler.postDelayed(run, 4000); // slide duration 2 seconds
            }
        });

    }

    val run = object : Runnable {
        override fun run() {
            binding.viewPagerImageSlider.setCurrentItem(binding.viewPagerImageSlider.getCurrentItem() + 1);
        }
    }


}
