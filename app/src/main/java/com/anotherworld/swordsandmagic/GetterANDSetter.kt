package com.anotherworld.swordsandmagic

import java.io.File
import java.io.FileInputStream

class GetterANDSetter {
    val s_package : String = "com.anotherworld.swordsandmagic/"
    val file1 = File("data/data/"+s_package+"load.txt")
    val file_money = File("data/data/" + s_package + "money.txt")
    val file_name = File("data/data/" + s_package + "nickname.txt")
    val file_sign = File("data/data/" + s_package + "sign.txt")
    fun getSign() : Int{
        val read4 = FileInputStream(file_sign).bufferedReader().use { it.readText() }
        return read4.toInt()
    }
    fun setSign(i: Int){
        file_sign.appendText(i.toString())
    }
    fun getName() : String{
        val read3 = FileInputStream(file_name).bufferedReader().use { it.readText() }
        return read3
    }
    fun setName(s: String){
        file_name.appendText(s)
    }
    fun getMoney() : Double{
        val read2 = FileInputStream(file_money).bufferedReader().use { it.readText() }
        return read2.toDouble()
    }
    fun setMoney(d: Double){
        file_money.appendText(d.toString())
    }
    fun getLoad() : String{
        val read1 = FileInputStream(file1).bufferedReader().use { it.readText() }
        return read1
    }
    fun setLoad(s: String){
        file1.appendText(s)
    }
}