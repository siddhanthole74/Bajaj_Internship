package com.example.bugscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.DrawableImageViewTarget

class BugDetailsForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bug_details_form)
        val gifImageView = findViewById<ImageView>(R.id.avatar_image_view)
        Glide.with(this)
            .load(R.drawable.search11111)
            .into(DrawableImageViewTarget(gifImageView))
    }
}