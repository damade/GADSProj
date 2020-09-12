package com.example.gadsproj.Activities

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.gadsproj.Adapters.GadsViewPagerAdapter
import com.example.gadsproj.Fragments.FragmentLeaders
import com.example.gadsproj.Fragments.FragmentSkills
import com.example.gadsproj.R
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewPager: ViewPager2 = findViewById(R.id.viewPager)
        var tabLayout: TabLayout = findViewById(R.id.tabs)
        var submit: Button = findViewById(R.id.submit)
        var tabItemsLeaders: TabItem = findViewById(R.id.tabLeader)
        var tabItemSkills: TabItem = findViewById(R.id.tabSkills)

        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.colorWhite)))

        val fragmentList = arrayListOf(
            FragmentLeaders.newInstance(),
            FragmentSkills.newInstance()
        )

        val viewPagerAdapter = GadsViewPagerAdapter(this, fragmentList)
        viewPager.setAdapter(viewPagerAdapter)
        viewPager.currentItem

        //setSupportActionBar(toolbar)

        TabLayoutMediator(tabLayout, viewPager) {
            tab, position ->
            viewPager.setCurrentItem(tab.position, true)
        }.attach()


    }

}