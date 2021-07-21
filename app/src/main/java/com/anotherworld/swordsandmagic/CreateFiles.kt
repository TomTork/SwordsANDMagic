package com.anotherworld.swordsandmagic

import java.io.File

class CreateFiles {
    val s_package : String = "com.anotherworld.swordsandmagic/"
    fun create(){
        val file1 = File("data/data/"+s_package+"load.txt")
        val file_money = File("data/data/" + s_package + "money.txt")
        val file_name = File("data/data/" + s_package + "nickname.txt")
        val file_sign = File("data/data/" + s_package + "sign.txt")
        file_sign.createNewFile()
        file_sign.appendText("0")
        file1.createNewFile()
        file_money.createNewFile()
        file_name.createNewFile()
    }
}