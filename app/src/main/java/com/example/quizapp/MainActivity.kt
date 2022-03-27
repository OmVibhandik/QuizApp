package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnStart : Button = findViewById(R.id.BtnStart)
        val etName : EditText = findViewById(R.id.Edittext)

        BtnStart.setOnClickListener {
            if (etName.text.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Constant.entername,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}