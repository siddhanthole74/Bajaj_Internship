package com.example.bugscount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        // Load the animated image
        val gifImageView = findViewById<GifImageView>(R.id.gifImageView)
        val gifDrawable = GifDrawable(resources, R.drawable.letterb)
        gifImageView.setImageDrawable(gifDrawable)

         //Delay for some time and then launch the next activity
        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, AuthSelectionActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}