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
    val file_image = File("data/data/" + s_package + "image.txt")
    val file_gallery = File("data/data/" + s_package + "gallery.txt")
    val file_chat = File("data/data/" + s_package + "chat.txt")
    val file_common = File("data/data/" + s_package + "common.txt")
    val file_ultimate = File("data/data/" + s_package + "ultimate.txt")
    fun setUltimate(i:Int){
        file_ultimate.writeText(i.toString())
    }
    fun getUltimate():Int{
        val read9 =  FileInputStream(file_ultimate).bufferedReader().use { it.readText() }
        return read9.toInt()
    }
    fun setCommon(i:Int){
        file_common.writeText(i.toString())
    }
    fun getCommon() : Int{
        val read9 = FileInputStream(file_common).bufferedReader().use { it.readText() }
        return read9.toInt()
    }
    fun setChat(i:Int){
        file_chat.writeText(i.toString())
    }
    fun getChat() : Int{
        val read8 = FileInputStream(file_chat).bufferedReader().use { it.readText() }
        return read8.toInt()
    }
    fun setGallery(i:Int){
        file_gallery.writeText(i.toString())
    }
    fun getGallery() : Int{
        val read7 = FileInputStream(file_gallery).bufferedReader().use { it.readText() }
        return read7.toInt()
    }
    fun setImage(s:String){
        file_image.writeText(s)
    }
    fun getImage() : String{
        val read6 = FileInputStream(file_image).bufferedReader().use { it.readText() }
        return read6
    }
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