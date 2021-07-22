package com.anotherworld.swordsandmagic

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){
    var i: Int = 0
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                ThirdFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return when(position){
//            0 -> "1"
//            1 -> "2"
//            else -> return "3"
//        }
//    }
}