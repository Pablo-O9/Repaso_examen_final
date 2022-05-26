package com.example.repaso_examen_final.ejercicios.examen

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.ActivityMainExamBinding

class MainExamActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainExamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainExamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main_exam)

//        appBarConfiguration = AppBarConfiguration(navController.graph,binding.drawerLayoutExam)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_exam, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main_exam)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    val positiveButtonClick = {dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,android.R.string.yes, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_info-> AlertDialog.Builder(binding.root.context).setMessage("Proyecto de examen del 3er trimestre")
                .setTitle("Información").setPositiveButton("ok",DialogInterface.OnClickListener(function = positiveButtonClick)).create().show()
        }


        return super.onOptionsItemSelected(item)
    }
}