package com.example.bugscount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class GeneralUserLoginActivity : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signInButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_user_login)
        val gifImageView = findViewById<ImageView>(R.id.avatar_image_view)
        Glide.with(this)
            .asGif()
            .load(R.drawable.usergggg)
            .into(gifImageView)

        emailInput = findViewById(R.id.emailEt)
        passwordInput = findViewById(R.id.passET)
        signInButton = findViewById(R.id.buttonsign)
// Add text change listeners to email and password inputs
        // Disable sign-in button by default
        signInButton.isEnabled = false
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val email = emailInput.text.toString().trim()
                val password = passwordInput.text.toString().trim()

                // Check if email is valid
                if (!isValidEmail(email)) {
                    emailInput.setError("Invalid email format", resources.getDrawable(R.drawable.custom_error_drawable)) // set custom error drawable
                } else {
                    emailInput.error = null
                }

                // Check if password is valid
                if (!isValidPassword(password)) {
                    passwordInput.setError("Invalid password format. Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character. ", resources.getDrawable(R.drawable.custom_error_drawable)) // set custom error drawable
                } else {
                    passwordInput.error = null
                }

                // Enable/disable sign-in button based on email and password validity
                signInButton.isEnabled = emailInput.error == null && passwordInput.error == null
            }
        }
        emailInput.addTextChangedListener(textWatcher)
        passwordInput.addTextChangedListener(textWatcher)

        // Add click listener to sign-in button
        signInButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Perform sign-in operation

            // Create an instance of the AdminHomeScreenFragment class

            startActivity(Intent(this, AdminHomeScreenActivity::class.java))
            Toast.makeText(this, "Sign-in successful", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Check if password is valid
    private fun isValidPassword(password: String): Boolean {
        val pattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+\$).{8,}$")
        return pattern.matches(password)
    }
}
