package com.example.marketplace.myfare.adapter

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import com.example.marketplace.myfare.fragment.MyFareFragment
import com.example.marketplace.myfare.fragment.OngoingOrdersFragment
import com.example.marketplace.myfare.fragment.OngoingSalesFragment


class ViewPageAdapter(fa: FragmentActivity) :   FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        if(position == 0)
        {
            return OngoingSalesFragment()
        }
        else{
            return OngoingOrdersFragment()
        }
    }

}
