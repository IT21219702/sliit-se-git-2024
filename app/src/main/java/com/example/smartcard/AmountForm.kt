package com.example.smartcard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AmountForm : AppCompatActivity() {

    private lateinit var amountEditText: EditText
    private lateinit var confirmButton: Button
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amount_form)

        amountEditText = findViewById(R.id.enterPin)
        confirmButton = findViewById(R.id.confirmBtn)

        confirmButton.setOnClickListener {
            // Get the amount entered by the user
            val amount = amountEditText.text.toString().trim()

            if (amount.isNotEmpty()) {
                // Create a data structure to hold the amount
                val data = hashMapOf(
                    "amount" to amount
                    // Add more fields as needed
                )

                // Add the data to the "Smart Card" collection in Firestore
                db.collection("Smart Card")
                    .add(data)
                    .addOnSuccessListener { documentReference ->
                        // Handle a successful addition, e.g., show a success message
                    }
                    .addOnFailureListener { e ->
                        // Handle the error in case of failure, e.g., show an error message
                    }
            } else {
                // Handle the case when the user didn't enter an amount
                // You can show an error message or perform other actions here
            }
        }
    }
}
