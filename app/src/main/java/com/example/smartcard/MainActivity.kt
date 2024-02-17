package com.example.smartcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent



class  MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToNewActivity = findViewById<Button>(R.id.button1)
        buttonGoToNewActivity.setOnClickListener {
            val intent = Intent(this, smartCardValidation::class.java)
            startActivity(intent)
        }
    }
}