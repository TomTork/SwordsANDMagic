package com.anotherworld.swordsandmagic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_first.*


class MainActivity : AppCompatActivity() {
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    val createFiles: CreateFiles = CreateFiles()
    override fun onStart() {
        super.onStart()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            createFiles.create()
            if(FirebaseAuth.getInstance().currentUser.toString()=="null" && getterANDSetter.getSign()!=1)startActivity(Intent(this@MainActivity,EmailPasswordActivity::class.java))
            Thread.sleep(300)
        }catch (e:Exception){
            e.printStackTrace()
        }
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()
        val viewpager: ViewPager = findViewById(R.id.viewpager)
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)

    }
}