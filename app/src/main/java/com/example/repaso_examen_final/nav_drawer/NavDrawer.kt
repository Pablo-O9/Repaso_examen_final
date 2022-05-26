package com.example.repaso_examen_final.nav_drawer

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.repaso_examen_final.databinding.ActivityNavDrawerBinding
import com.example.repaso_examen_final.R

class NavDrawer : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavDrawerBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)


       setSupportActionBar(binding.appBarNavDrawer.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_nav_drawer) as NavHostFragment
         navController = navHostFragment.navController
        val navView: NavigationView = binding.navView

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.nav_autocompletar,R.id.nav_listView,R.id.nav_paso_argumentos, R.id.nav_spinners,R.id.nav_volver
            ), binding.drawerLayout
        )
//     appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it1 is present.
        menuInflater.inflate(R.menu.nav_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}