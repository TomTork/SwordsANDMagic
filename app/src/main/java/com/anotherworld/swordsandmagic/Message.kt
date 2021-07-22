package com.anotherworld.swordsandmagic

import java.util.*


class Message {
    var textMessage: String? = null
    var author: String? = null
    var messageTime: Long = 0
    var email: String? = null

    constructor(textMessage: String?, author: String?, email: String?) {
        this.textMessage = textMessage
        this.email = email
        this.author = author
        messageTime = Date().time
    }

    constructor() {}
}