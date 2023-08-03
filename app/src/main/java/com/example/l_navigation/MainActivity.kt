package com.example.l_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.l_navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpControllerAndToolbar()
        setUpActionBar()
        setUpNavDrawer()
        setUpDestinationChangeListener()
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun setUpControllerAndToolbar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        toolbar = binding.toolbar
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
    }

    private fun setUpDestinationChangeListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            destination.label = null
        }
    }

    private fun setUpNavDrawer() {
        binding.navDrawer.setupWithNavController(navController)
    }

    private fun setUpActionBar() {
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.mipmap.app_icon)
        supportActionBar?.setDisplayUseLogoEnabled(true)
    }
}