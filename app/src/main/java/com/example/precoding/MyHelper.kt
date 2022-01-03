package com.example.precoding

import android.database.sqlite.SQLiteOpenHelper
import com.example.precoding.MyHelper
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context

class MyHelper(context: Context?) : SQLiteOpenHelper(context, dbname, null, version) {
    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE users (username TEXT, password TEXT)"
        db.execSQL(sql)
        //insert
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists users")
    }

    fun insertData(username: String?, password: String?): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val result = db.insert("users", null, contentValues)
        return if (result == -1L) false else true
    }

    fun checkusername(username: String): Boolean {
        val db = this.writableDatabase
        val cursor = db.rawQuery("select * from users where username=?", arrayOf(username))
        return if (cursor.count > 0) true else false
    }

    fun checkUsernamePass(username: String, password: String): Boolean {
        val Mydb = this.writableDatabase
        val cursor = Mydb.rawQuery(
            "select * from users where username=? and password =?",
            arrayOf(username, password)
        )
        return if (cursor.count > 0) true else false
    }

    companion object {
        private const val dbname = "mydb.db"
        private const val version = 1
    }
}