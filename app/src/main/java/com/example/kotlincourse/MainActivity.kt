package com.example.kotlincourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.kotlincourse.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

//        setupNavigationComponent()
    }

//    private fun setupNavigationComponent() {
//        val navHostFragment:NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment , R.id.singleNoteFragment) , binding.drawerLayout)
//
//        binding.navView.setupWithNavController(navController)
//
//
//        val popupMenu = android.widget.PopupMenu(this , null)
//        popupMenu.inflate(R.menu.menu_bottom)
//        val menu = popupMenu.menu
//        binding.bottomBar.setupWithNavController(menu , navController)
//
//    }
}