package com.anotherworld.swordsandmagic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Game : AppCompatActivity() {
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()
    }
}