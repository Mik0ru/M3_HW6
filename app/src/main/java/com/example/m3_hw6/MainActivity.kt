package com.example.m3_hw6

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailEditText = findViewById<EditText>(R.id.ed_email)
        val subjectEditText = findViewById<EditText>(R.id.ed_subject)
        val messageEditText = findViewById<EditText>(R.id.ed_message)
        val emailButton = findViewById<Button>(R.id.emailButton)
        emailButton.setOnClickListener{
            val email = emailEditText.text.toString().trim()
            val subject = subjectEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()
            sendEmail(email, subject, message)
        }

    }
    private fun sendEmail(email : String, subject : String, message : String){
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.setDataAndType(Uri.parse("mail.to"),"text/plain")
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, message)
        try {
            startActivity(Intent.createChooser(emailIntent,"Choose Email Service"))
        }
        catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

}