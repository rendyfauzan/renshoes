package com.example.sportshoes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.util.logging.Filter

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginmasuk(view: View) {
        val Uname   = username.text.toString()
        val Pswd    = password.text.toString()

        if (Uname.isEmpty() || Pswd.isEmpty()){
            Toast.makeText(this,"Isikan Username atau Password Dahulu", Toast.LENGTH_SHORT).show()
        }else if (Uname.toLowerCase() == "rendy" && Pswd.toLowerCase() == "123456"){
            Toast.makeText(this,"Login Sukses", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
        }else{
            Toast.makeText(this,"username dan password salah", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}