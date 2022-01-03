package com.example.precoding

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class ListActivity : Activity() {
    var simpleList: ListView? = null
    var programList = arrayOf("Hello world!", "Binary Search", "Circular Queue", "Linked List", "Stack", "Perfect Number","Fibonacci Series","Niven Number")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        simpleList = findViewById<View>(R.id.simpleListView) as ListView
        val arrayAdapter = ArrayAdapter(this, R.layout.listview,programList)
        simpleList!!.adapter = arrayAdapter
    }
}