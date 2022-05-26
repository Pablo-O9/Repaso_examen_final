package com.example.repaso_examen_final.ejercicios.examen

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.FragmentSecondBinding
import com.example.repaso_examen_final.ejercicios.examen.CustomAdapter2


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    var listaCanciones: MutableList<Album> = ArrayList()
    var listadoRock: MutableList<Album> = ArrayList()
    var listadoBlues: MutableList<Album> = ArrayList()
    var listadoJazz: MutableList<Album> = ArrayList()
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        cargarLista()

        binding.checkBoxRock.setOnClickListener { comprobar() }
        binding.checkBoxBlues.setOnClickListener { comprobar() }
        binding.checkBoxJazz.setOnClickListener { comprobar() }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun cargarLista() {
        listadoRock = ArrayList()

        listadoRock.add(
            Album(
                "Abbey Road", "The Beatles", R.drawable.abbeyroad,
                resources.getString(R.string.abbeyroad)
            )
        )
        listadoRock.add(
            Album(
                "Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst,
                resources.getString(R.string.exilesonmainstreet)
            )
        )
        listadoRock.add(
            Album(
                "The Velvet Underground",
                "The Velvet Underground and Nico",
                R.drawable.velvetunderground,
                resources.getString(R.string.velvetunderground)
            )
        )
        listadoRock.add(
            Album(
                "Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced,
                resources.getString(R.string.areyouexperienced)
            )
        )
        listadoRock.add(
            Album(
                "Back in Black", "AC/DC", R.drawable.backinblack,
                resources.getString(R.string.backinblack)
            )
        )
        listadoRock.add(
            Album(
                "Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction,
                resources.getString(R.string.appetitefordestruction)
            )
        )
        listadoRock.add(
            Album(
                "Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv,
                resources.getString(R.string.ledzeppeliniv)
            )
        )


        listadoBlues = ArrayList()
        listadoBlues.add(
            Album(
                "Lady Soul", "Aretha Franklin", R.drawable.ladysoul,
                resources.getString(R.string.ladysoul)
            )
        )
        listadoBlues.add(
            Album(
                "I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved,
                resources.getString(R.string.ineverloveda)
            )
        )
        listadoBlues.add(
            Album(
                "What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,
                resources.getString(R.string.whatsgoingon)
            )
        )


        listadoJazz = ArrayList()
        listadoJazz.add(
            Album(
                "Kind of Blue", "Miles Davis", R.drawable.kindofblue,
                resources.getString(R.string.kindofblue)
            )
        )
        listadoJazz.add(
            Album(
                "Bitches Brew", "Miles Davis", R.drawable.bitchesbrew,
                resources.getString(R.string.bitchesbrew)
            )
        )
        listadoJazz.add(
            Album(
                "A Love Supreme", "John Coltrane", R.drawable.alovesupreme,
                resources.getString(R.string.alovesupreme)
            )
        )
    }

    private fun comprobar() {
        listaCanciones.clear()
        if (binding.checkBoxRock.isChecked) listaCanciones.addAll(listadoRock)
        if (binding.checkBoxBlues.isChecked) listaCanciones.addAll(listadoBlues)
        if (binding.checkBoxJazz.isChecked) listaCanciones.addAll(listadoJazz)

        with(binding.recyclerView) {
            adapter = CustomAdapter2(listaCanciones)

            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}



