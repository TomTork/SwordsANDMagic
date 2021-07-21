package com.anotherworld.swordsandmagic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    override fun onStart() {
        super.onStart()
        if (getterANDSetter.getSign()==0)startActivity(Intent(this@MainActivity,EmailPasswordActivity::class.java))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val viewpager: ViewPager = findViewById(R.id.viewpager)
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)

    }
}