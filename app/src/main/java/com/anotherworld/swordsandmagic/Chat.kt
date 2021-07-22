package com.anotherworld.swordsandmagic

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import com.firebase.ui.database.FirebaseListAdapter
import com.github.library.bubbleview.BubbleTextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Chat : AppCompatActivity() {
    lateinit var number_of_words_entered: TextView
    lateinit var input: EditText
    lateinit var send: AppCompatImageButton
    lateinit var listView: ListView
    var adapter: FirebaseListAdapter<Message>? = null
    var textMessage: BubbleTextView? = null
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    var xy = true
    var sec: Int = 1
    var count = 0
    var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        supportActionBar?.hide()
        send = findViewById(R.id.send)
        number_of_words_entered = findViewById(R.id.number_of_words_entered)
        input = findViewById(R.id.input)
        listView = findViewById(R.id.listView)
        send.setOnClickListener {
            Log.d("QQQQQ_C","TRUE")
            FirebaseDatabase.getInstance().getReference("Message").push().setValue(Message(input.text.toString(), getterANDSetter.getName(), FirebaseAuth.getInstance().currentUser!!.email + ""))
            input.setText("")
            xy = true
        }
        displayChat()
        timer()
    }
    fun timer(){
        val toast = Toast.makeText(applicationContext, "Вы превысили ограничение!", Toast.LENGTH_SHORT)
        countDownTimer = object : CountDownTimer((sec * 10).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                sec--
                count = input.text.toString().length
                number_of_words_entered.text = count.toString() + ""
                if (count > 550) { // Более быстрый таймер для проверки количества букв в сообщении, они не должны превышать 550 символов
                    number_of_words_entered.setTextColor(Color.RED)
                    toast.show()
                } else {
                    toast.cancel()
                    number_of_words_entered.setTextColor(resources.getColor(R.color.grey_500))
                }
            }
            override fun onFinish() {
                count = input.text.toString().length
                number_of_words_entered.text = count.toString() + ""
                if (countDownTimer != null) { // Перезапуск таймера
                    sec = 1
                    countDownTimer!!.start()
                }
            }
        }
        if (countDownTimer != null) { // Перезапуск таймера
            sec = 1
            countDownTimer!!.start()
        }
    }
    fun displayChat() { // Метод отображения сообщений в чате (FirebaseListAdapter)
        val listMessages = findViewById<ListView>(R.id.listView)
        adapter = object : FirebaseListAdapter<Message>(this@Chat, Message::class.java, R.layout.list_item, FirebaseDatabase.getInstance().getReference("Message")) {
            override fun populateView(v: View, model: Message, position: Int) {
                val author: TextView = v.findViewById(R.id.tvUser)
                textMessage = v.findViewById(R.id.tvMessage)
                textMessage!!.text = model.textMessage
                author.text = model.author
                if (getterANDSetter.getName() == author.text.toString()) {
                    author.setTextColor(resources.getColor(R.color.user))
                    listView.smoothScrollToPosition(2000000000)
                }
                else author.setTextColor(resources.getColor(R.color.user2))
                if (xy) {
                    listView.smoothScrollToPosition(2000000000)
                    xy = false
                }
            }
        }
        listMessages.adapter = adapter
    }
}