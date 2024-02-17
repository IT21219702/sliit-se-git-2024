package com.example.smartcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class paymentMethod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_method)

        val selectCrditcard = findViewById<ImageButton>(R.id.imageButton1)
        selectCrditcard.setOnClickListener {
            val intent = Intent(this, paymentForm::class.java)
            startActivity(intent)
        }

        val selectCash = findViewById<ImageButton>(R.id.imageButton2)
        selectCash.setOnClickListener {
            val intent = Intent(this, AmountForm::class.java)
            startActivity(intent)
        }
    }
}