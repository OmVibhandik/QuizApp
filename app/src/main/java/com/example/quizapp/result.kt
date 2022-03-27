package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.time.Instant

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val Name: TextView = findViewById(R.id.Name)
        val Score: TextView = findViewById(R.id.score)
        val finishbtn: TextView = findViewById(R.id.FinalBTN)

        Name.text = intent.getStringExtra(Constant.entername)

        val totalQuestion = intent .getIntExtra(Constant.totquestion,0)
        val correctanswer = intent.getIntExtra(Constant.corranswer,0)

        Score.text = "${correctanswer}/${totalQuestion}"

        finishbtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}