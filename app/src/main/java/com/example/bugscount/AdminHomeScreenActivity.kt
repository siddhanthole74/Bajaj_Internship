package com.example.bugscount

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView

class AdminHomeScreenActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home_screen)
        val gifImageView = findViewById<GifImageView>(R.id.notificationbells)
        val gifDrawable = GifDrawable(resources, R.drawable.notificatopnbell1111)
        gifImageView.setImageDrawable(gifDrawable)
        val gifImageView1 = findViewById<GifImageView>(R.id.drawergif)
        val gifDrawable1 = GifDrawable(resources, R.drawable.drawer11)
        gifImageView1.setImageDrawable(gifDrawable1)

        drawerLayout = findViewById(R.id.adminhomescreenactivity)
        val navview: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navview.setNavigationItemSelectedListener { menuItem ->
            // Check the selected menu item
            menuItem.isChecked = true

            // Handle the selected menu item
            when (menuItem.itemId) {
                R.id.nav_dashboard -> {
                    startActivity(Intent(this, AdminDashBoardActivity::class.java))
//                    finish()
                }
                R.id.bug_list->{
                    startActivity(Intent(this, BugList::class.java))
                }
                R.id.bug_details_form->{
                    startActivity(Intent(this, BugDetailsForm::class.java))
                }
                R.id.create_user->{
                    startActivity(Intent(this, AdminCreateActivity::class.java))
                }
                R.id.qatester ->{
                    startActivity(Intent(this, AdminQATesterActivity::class.java))
                }
                R.id.view_user ->{
                    startActivity(Intent(this, ViewUserActivity::class.java))
                }
                R.id.modify_user->{
                    startActivity(Intent(this, AdminModifyUserActivity::class.java))
                }

                R.id.admin_account->{
                    startActivity(Intent(this, AdminAccountDetails::class.java))
                }

            }

            //Close the NavigationView
            drawerLayout.closeDrawers()

            // Return true to indicate that the event has been handled
            true
        }

    }

}