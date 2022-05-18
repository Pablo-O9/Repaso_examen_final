package com.example.repaso_examen_final.ejercicios.ciclo_vida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.CicloVidaBinding

class CicloVidaActivity : AppCompatActivity() {
    private lateinit var binding: CicloVidaBinding
    var aux: String = ""

    //prueba de abajo
    // private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CicloVidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        Probando a meter un navdrawer de otro lado
        val drawerLayout: DrawerLayout =
        val navController = findNavController(R.id.nav_host_fragment_content_nav_drawer)
        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)
*/

        binding.txview.setText(savedInstanceState.toString())

        binding.btnEventos.setOnClickListener() {
            modificar_marcador()
        }

        binding.pixel1.visibility = View.GONE
        binding.pixel2.visibility = View.GONE
        binding.pixel3.visibility = View.GONE
        binding.pixel4.visibility = View.GONE

        binding.btnPausa.setOnClickListener() { onPause() }
        loader()

    }

    fun modificar_marcador() {
        binding.marcador.setText("comprobando la funcionalidad del boton eventos")
        onDestroy()
    }

    fun loader() {
        val timer = object : CountDownTimer(200000, 500) {
            var i = 0
            var count = 0
            override fun onTick(millisUntilFinished: Long) {
                if (i == 8) i = 0
                count++
                binding.tvcontador.setText(count.toString())
                when (i) {
                    0 -> {
                        binding.pixel1.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.pixel2.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.pixel3.visibility = View.VISIBLE
                    }
                    3 -> {
                        binding.pixel4.visibility = View.VISIBLE
                    }
                    4 -> {
                        binding.pixel4.visibility = View.GONE
                    }
                    5 -> {
                        binding.pixel3.visibility = View.GONE
                    }
                    6 -> {
                        binding.pixel2.visibility = View.GONE
                    }
                    7 -> {
                        binding.pixel1.visibility = View.GONE
                    }

                }
                i++
            }

            override fun onFinish() {}
        }
        timer.start()

    }

    override fun onPause() {
        super.onPause()
        aux = "pausado"
        binding.tvaux.setText(aux)


    }

    override fun onResume() {
        super.onResume()
        binding.tvaux.setText(aux)
        binding.txview.setText(Lifecycle.Event.ON_PAUSE.toString())


    }

}