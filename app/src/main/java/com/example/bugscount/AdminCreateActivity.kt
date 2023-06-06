package com.example.bugscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.DrawableImageViewTarget

class AdminCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_create)
        val gifImageView = findViewById<ImageView>(R.id.avatar_image_view)
        Glide.with(this)
            .load(R.drawable.socialmedia)
            .into(DrawableImageViewTarget(gifImageView))
    }
}