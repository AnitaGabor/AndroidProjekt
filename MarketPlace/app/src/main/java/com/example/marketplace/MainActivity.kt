package com.example.marketplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.myNavHostFragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)


        bottomNav.setOnItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.menu_timeline -> {
                    findNavController(R.id.myNavHostFragment).navigate(R.id.timeLineFragment)
                }
                R.id.menu_mymarket -> {
                    //Navigation.findNavController(this,R.id.myNavHostFragment).navigate(R.id.)
                }
                R.id.menu_myfare -> {
                    //Navigation.findNavController(this,R.id.myNavHostFragment).navigate(R.id.profileFragment)
                }

            }
            menuItem.isChecked=true
            true
        }


        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.myNavHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}