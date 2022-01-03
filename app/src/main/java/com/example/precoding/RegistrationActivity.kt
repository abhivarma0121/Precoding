package com.example.precoding

import android.app.Activity
import android.widget.EditText
import com.example.precoding.MyHelper
import android.os.Bundle
import com.example.precoding.R
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.precoding.LoginActivity

class RegistrationActivity : Activity() {
    var username: EditText? = null
    var password: EditText? = null
    var repass: EditText? = null
    var email: EditText? = null
    var signup: Button? = null
    var helper: MyHelper? = null
    var checkUsername: Boolean? = null
    var insert: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById<View>(R.id.username) as EditText
        email = findViewById<View>(R.id.email) as EditText
        password = findViewById<View>(R.id.password) as EditText
        repass = findViewById<View>(R.id.repassword) as EditText
        signup = findViewById<View>(R.id.signup) as Button
        helper = MyHelper(this)
        signup!!.setOnClickListener {
            val user = username!!.text.toString()
            val pass = password!!.text.toString()
            val rpwd = repass!!.text.toString()
            if (user == "" || pass == "" || rpwd == "") {
                Toast.makeText(
                    this@RegistrationActivity,
                    "please enter all the fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (pass == rpwd) {
                    checkUsername = helper!!.checkusername(user)
                    if (checkUsername == false) {
                        insert = helper!!.insertData(user, pass)
                        if (insert == true) {
                            Toast.makeText(
                                this@RegistrationActivity,
                                "Registered Successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(applicationContext, LoginActivity::class.java)
                            startActivity(intent)
                        } else Toast.makeText(
                            this@RegistrationActivity,
                            "Registered failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else Toast.makeText(
                        this@RegistrationActivity,
                        "User Already exists",
                        Toast.LENGTH_SHORT
                    ).show()
                } else Toast.makeText(
                    this@RegistrationActivity,
                    "password not matching ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}