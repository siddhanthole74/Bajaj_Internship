package com.example.bugscount

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.RadioGroup


class AuthSelectionActivity : AppCompatActivity() {
    private lateinit var loginOptionsGroup: RadioGroup
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_selection)
        loginOptionsGroup = findViewById(R.id.login_options_group)
        loginButton = findViewById(R.id.login_button)

        animateOptions()
        loginButton.setOnClickListener {
            when (loginOptionsGroup.checkedRadioButtonId) {
                R.id.admin_button -> {
                    // Navigate to admin login screen
                    startActivity(Intent(this, AdminLoginScreenActivity::class.java))
                }
                R.id.user_button -> {
                    // Navigate to Gerneral login screen
                    startActivity(Intent(this, GeneralUserLoginActivity::class.java))

                }
                R.id.qa_button -> {
                    // Navigate to QA tester login screen
                    startActivity(Intent(this, LoginQAUserActivity::class.java))
                }
            }
        }
    }
    private fun animateOptions() {
        val duration = 1500L
        val delay = 500L
        val interpolator = AccelerateDecelerateInterpolator()

        val scaleX = ObjectAnimator.ofFloat(loginOptionsGroup, "scaleX", 0f, 1f)
        scaleX.duration = duration
        scaleX.interpolator = interpolator
        scaleX.startDelay = delay
        scaleX.start()

        val scaleY = ObjectAnimator.ofFloat(loginOptionsGroup, "scaleY", 0f, 1f)
        scaleY.duration = duration
        scaleY.interpolator = interpolator
        scaleY.startDelay = delay
        scaleY.start()
    }
}