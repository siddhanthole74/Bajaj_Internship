package com.example.bugscount

import android.content.Intent
import android.os.Build
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
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth



class AdminLoginScreenActivity : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signInButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login_screen)
        val gifImageView = findViewById<ImageView>(R.id.avatar_image_view)
        Glide.with(this)
            .asGif()
            .load(R.drawable.usergggg)
            .into(gifImageView)
        auth = FirebaseAuth.getInstance()

        emailInput = findViewById(R.id.emailEt)
        passwordInput = findViewById(R.id.passET)
        signInButton = findViewById(R.id.buttonsign)

        signInButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty()) {
                emailInput.error = "Email is required."
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (!isValidEmail(email)) {
                emailInput.error = "Invalid email format."
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordInput.error = "Password is required."
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (!isValidPassword(password)) {
                passwordInput.error = "Invalid password format. Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character."
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        // Navigate to the next activity
                        val intent = Intent(this, AdminHomeScreenActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        val pattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+\$).{8,}$")
        return pattern.matches(password)
    }
}