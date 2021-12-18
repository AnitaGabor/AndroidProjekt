package com.example.marketplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.myNavHostFragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        bottomNav?.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.registerFragment || destination.id == R.id.forgetPasswordFragment
                || destination.id == R.id.loginFragment) {

                bottomNav.visibility = View.GONE
            } else {

                bottomNav.visibility = View.VISIBLE
            }
        }


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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            findNavController(R.id.myNavHostFragment).navigate(R.id.settingsFragment)
            true
        }

        R.id.action_search -> {

            true
        }
        R.id.action_profile ->{
            findNavController(R.id.myNavHostFragment).navigate(R.id.profileFragment)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}