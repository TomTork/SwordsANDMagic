package com.anotherworld.swordsandmagic

import java.io.File
import java.io.FileInputStream

class GetterANDSetter {
    val s_package : String = "com.anotherworld.swordsandmagic/"
    val file1 = File("data/data/"+s_package+"load.txt")
    val file_money = File("data/data/" + s_package + "money.txt")
    val file_name = File("data/data/" + s_package + "nickname.txt")
    val file_sign = File("data/data/" + s_package + "sign.txt")
    val file_temp = File("data/data/" + s_package + "temp.txt")
    fun getTemp() : Int{
        val read5 = FileInputStream(file_temp).bufferedReader().use { it.readText() }
        return read5.toInt()
    }
    fun setTemp(i: Int){
        file_temp.writeText(i.toString())
    }
    fun getSign() : Int{
        val read4 = FileInputStream(file_sign).bufferedReader().use { it.readText() }
        return read4.toInt()
    }
    fun setSign(i: Int){
        file_sign.writeText(i.toString())
    }
    fun getName() : String{
        val read3 = FileInputStream(file_name).bufferedReader().use { it.readText() }
        return read3
    }
    fun setName(s: String){
        file_name.writeText(s)
    }
    fun getMoney() : Double{
        val read2 = FileInputStream(file_money).bufferedReader().use { it.readText() }
        return read2.toDouble()
    }
    fun setMoney(d: Double){
        file_money.writeText(d.toString())
    }
    fun getLoad() : String{
        val read1 = FileInputStream(file1).bufferedReader().use { it.readText() }
        return read1
    }
    fun setLoad(s: String){
        file1.writeText(s)
    }
}