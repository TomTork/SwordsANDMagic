package com.anotherworld.swordsandmagic

import java.io.File

class CreateFiles {
    val s_package : String = "com.anotherworld.swordsandmagic/"
    fun create(){
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
        file_common.createNewFile()
        file_ultimate.createNewFile()
        file_chat.createNewFile()
        file_gallery.createNewFile()
        file_image.createNewFile()
        file_sign.createNewFile()
        file_temp.createNewFile()
        file_common.writeText("0")
        file_ultimate.writeText("0")
        file_chat.writeText("0")
        file_sign.writeText("0")
        file_temp.writeText("0")
        file_money.writeText("0")
        file_gallery.writeText("0")
        file1.createNewFile()
        file_money.createNewFile()
        file_name.createNewFile()
    }
}