package com.example.l_navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.l_navigation.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomappbar.BottomAppBar

class BottomNavActivity : AppCompatActivity() {
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var navController: NavController
    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navHostFragment.navController
        bottomAppBar = binding.bottomAppBar

        bottomAppBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.firstFragment -> {
                    if (navController.currentDestination == navController.findDestination(R.id.firstFragment))
                        return@setOnMenuItemClickListener true
                    Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
                    navController.navigateUp()
                    true
                }

                R.id.secondFragment -> {
                    if (navController.currentDestination == navController.findDestination(R.id.secondFragment))
                        return@setOnMenuItemClickListener true
                    Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.secondFragment)
                    true
                }

                else -> true
            }
        }

    }

}
