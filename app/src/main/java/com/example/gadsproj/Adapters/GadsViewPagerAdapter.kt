package com.example.gadsproj.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class GadsViewPagerAdapter(fa: FragmentActivity, private val fragments: ArrayList<Fragment>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        fragment = fragments[position]
        return fragment!!
    }

}
