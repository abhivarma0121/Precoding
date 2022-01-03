package com.example.precoding

import android.os.Bundle
import com.example.precoding.R
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.precoding.c
import com.example.precoding.java
import com.example.precoding.python
import com.example.precoding.php

class Course : AppCompatActivity() {
    var c: Button? = null
    var java: Button? = null
    var python: Button? = null
    var php: Button? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        val c = findViewById(R.id.c) as Button
        val java = findViewById(R.id.java) as Button
        val python = this.python.findViewById<View>() as Button
        val php = php!!.findViewById<View>() as Button
        c.setOnClickListener { val intent = Intent(this@Course, c::class.java) }
        java.setOnClickListener { val intent = Intent(this@Course, java::class.java) }
        python.setOnClickListener { val intent = Intent(this@Course, python::class.java) }
        php.setOnClickListener { val intent = Intent(this@Course, php::class.java) }
    }

    fun setContentView(contentView: Int) {
        contentView = contentView
    }
}