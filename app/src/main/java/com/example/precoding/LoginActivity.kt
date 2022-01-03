package com.example.precoding

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var login: Button? = null
    var helper: MyHelper? = null
    var checkUsernamePass: Boolean? = null
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username = findViewById(R.id.username1) as EditText?
        password = findViewById(R.id.password1) as EditText?
        login = findViewById(R.id.login) as Button?
        helper = MyHelper(this)
        login!!.setOnClickListener {
            val user: String = username.getText().toString()
            val pass: String = password.getText().toString()
            if (user == "" || pass == "") {
                Toast.makeText(
                    this@LoginActivity,
                    "please enter all the fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                checkUsernamePass = helper!!.checkUsernamePass(user, pass)
                if (checkUsernamePass == true) {
                    Toast.makeText(this@LoginActivity, "sign in successful", Toast.LENGTH_SHORT)
                        .show()
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    val txt: TextView = (findViewById(R.id.text) as TextView).apply {
                        setText("welcome$user")
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "invalid Credentials", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun getApplicationContext(): String? {

    }

    private fun findViewById(username1: Int): Any {

    }

    private fun setContentView(activityLogin: Int) {

    }
}