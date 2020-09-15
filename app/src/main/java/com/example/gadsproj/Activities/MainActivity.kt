package com.example.gadsproj.Activities

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.gadsproj.Adapters.GadsViewPagerAdapter
import com.example.gadsproj.Fragments.FragmentLeaders
import com.example.gadsproj.Fragments.FragmentSkills
import com.example.gadsproj.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        val submit: Button = findViewById(R.id.goToSubmitPageButton)
        /*var tabItemsLeaders: TabItem = findViewById(R.id.tabLeader)
        var tabItemSkills: TabItem = findViewById(R.id.tabSkills)*/

        tabLayout.tabTextColors = ColorStateList.valueOf(resources.getColor(R.color.colorWhite))

        val fragmentList = arrayListOf(
            FragmentLeaders.newInstance(),
            FragmentSkills.newInstance()
        )

        val viewPagerAdapter = GadsViewPagerAdapter(this, fragmentList)
        viewPager.adapter = viewPagerAdapter
        viewPager.currentItem

        //setSupportActionBar(toolbar)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            val tabTitles = arrayOf("Learning Leaders", "Skill IQ Leaders")
            tab.text = tabTitles[position]
            viewPager.setCurrentItem(tab.position, true)
        }.attach()


        val clickListener = View.OnClickListener { view ->

            when (view.id) {
                R.id.goToSubmitPageButton -> startSubmissionActivity()
            }
        }

        submit.setOnClickListener(clickListener)
    }

    private fun startSubmissionActivity() {
        val intent = Intent(this, SubmissionActivity::class.java)
        // To pass any data to next activity
        //intent.putExtra("keyIdentifier", value)
        // start your next activity
        startActivity(intent)

    }

}