package com.example.marketplace.myfare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.marketplace.R
import com.example.marketplace.myfare.adapter.ViewPageAdapter


class MyFareFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my_fare, container, false)

//        val viewPager = view.findViewById<ViewPager2>(R.id.pager)
//        val pagerAdapter = ViewPageAdapter(requireActivity())
//        viewPager.adapter = pagerAdapter
        return view
    }


}
