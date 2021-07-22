package com.anotherworld.swordsandmagic

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    val createFiles: CreateFiles = CreateFiles()
    var sec: Int = 1
    var second: Int = 1
    var count: CountDownTimer? = null
    var countD: CountDownTimer? = null
    override fun onStart() {
        super.onStart()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            if(FirebaseAuth.getInstance().currentUser.toString()=="null")startActivity(Intent(this@MainActivity,EmailPasswordActivity::class.java))
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
        timer()
    }

    fun timer(){
        lifecycleScope.launch {
            count = object : CountDownTimer((sec * 10).toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    sec--
                    if(getterANDSetter.getTemp()==1){
                        getterANDSetter.setTemp(0)
                        startActivity(Intent(this@MainActivity,Game::class.java))
                    }
                }

                override fun onFinish() {
                    if (count != null) {
                        sec = 1
                        count!!.start()
                    }
                }
            }
            if (count != null) {
                sec = 1
                count!!.start()
            }
        }
    }

}