import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class smartCardValidationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var enterNumberEditText: EditText
    private lateinit var enterPinEditText: EditText
    private lateinit var confirmButton: Button

    private lateinit var smartCardReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        enterNumberEditText = findViewById(R.id.enterNumber)
        enterPinEditText = findViewById(R.id.enterPin)
        confirmButton = findViewById(R.id.confirmBtn)

        val database = FirebaseDatabase.getInstance()
        smartCardReference = database.getReference("smart_cards")

        confirmButton.setOnClickListener { verifySmartCard() }
    }

    private fun verifySmartCard() {
        val cardNumber = enterNumberEditText.text.toString().trim()
        val pin = enterPinEditText.text.toString().trim()

        // Query the database to check if the smart card exists
        smartCardReference.child(cardNumber).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val storedPin = dataSnapshot.child("pin").getValue(String::class.java)

                    if (pin == storedPin) {
                        // Smart card is valid
                        grantAccess()
                    } else {
                        // Incorrect PIN
                        displayErrorMessage("Incorrect PIN. Please try again.")
                    }
                } else {
                    // Smart card not found
                    displayErrorMessage("Smart card not found. Please check the card number.")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle the error
                displayErrorMessage("An error occurred. Please try again later.")
            }
        })
    }

    private fun grantAccess() {
        // You can implement your logic here to grant access to the user.
        // For example, start a new activity or show a success message.
        // You can also integrate with Firebase Authentication for user management.
    }

    private fun displayErrorMessage(message: String) {
        // You can implement your logic to display an error message to the user.
        // This could be a Toast, AlertDialog, or updating a TextView on the UI.
    }
}
