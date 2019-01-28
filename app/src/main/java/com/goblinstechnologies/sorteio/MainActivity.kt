package com.goblinstechnologies.sorteio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private var listItems: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems)
        val rollButton: Button = findViewById(R.id.main_button)
        val sortButton: Button = findViewById(R.id.main_sort_button)

        listView = findViewById(R.id.main_list_view)
        listView.adapter = adapter

        rollButton.setOnClickListener{
            addItem()
        }

        sortButton.setOnClickListener{
            sortItem()
        }
    }

    private fun sortItem() {
        val size = listItems.size
        val textView: TextView = findViewById(R.id.main_text_view)

        textView.text = ""

        val randomValue = Random.nextInt(0, size)
        val sorted = listItems.get(randomValue)

        textView.append("Deck sorteado $sorted")
    }

    private fun addItem() {
        val newItem: EditText = findViewById(R.id.main_edit_text)

        if(!newItem.text.isEmpty()) {
            listItems.add(newItem.text.toString())
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems)
            listView.adapter = adapter

            newItem.text.clear()
        }
    }
}
