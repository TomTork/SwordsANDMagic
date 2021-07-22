package com.anotherworld.swordsandmagic

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.OnProgressListener
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_email_password.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    val createFiles: CreateFiles = CreateFiles()
    var sec: Int = 1
    lateinit var storageReference: StorageReference
    var sP: String = ""
    private var filePath: Uri? = null
    private val PICK_IMAGE_REQUEST = 71
    var count: CountDownTimer? = null
    val my: MyPagerAdapter = MyPagerAdapter(supportFragmentManager)
    var storage: FirebaseStorage = FirebaseStorage.getInstance()
    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            try {
                if(FirebaseAuth.getInstance().currentUser.toString()=="null")startActivity(Intent(this@MainActivity,EmailPasswordActivity::class.java))
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val viewpager: ViewPager = findViewById(R.id.viewpager)
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        storageReference = storage.reference;
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
                    if (getterANDSetter.getGallery()==1){
                        getterANDSetter.setGallery(0)
                        startActivity(Intent(this@MainActivity,Preview::class.java))
                    }
                    if (getterANDSetter.getChat()==1){
                        getterANDSetter.setChat(0)
                        startActivity(Intent(this@MainActivity,Chat::class.java))
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