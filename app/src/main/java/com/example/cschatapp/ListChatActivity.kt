package com.example.cschatapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ListChatActivity : AppCompatActivity() {

    private lateinit var listViewMessages: ListView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: Button
    private val messages = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chat)

        listViewMessages = findViewById(R.id.listViewMessages)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSend = findViewById(R.id.buttonSend)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messages)
        listViewMessages.adapter = adapter

        buttonSend.setOnClickListener {
            val message = editTextMessage.text.toString()
            if (message.isNotBlank()) {
                messages.add("Kamu: $message")
                adapter.notifyDataSetChanged()
                editTextMessage.text.clear()
                listViewMessages.smoothScrollToPosition(messages.size - 1)
            }
        }
    }
}
