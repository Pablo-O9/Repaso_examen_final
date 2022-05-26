package com.example.repaso_examen_final.ejercicios.spinners

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.FragmentSpinnersBinding


class Spinners : Fragment() {

    private var _binding: FragmentSpinnersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpinnersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = binding.radioGroup.checkedRadioButtonId.toString()
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (i == 2131296846) {
                binding.spinner.onItemSelectedListener = null
                binding.btnSeleccion.setOnClickListener {
                    selected()
                }
            }
            if (i == 2131296847) {
                itemSeleccionado()
            }
        }

    }

    private fun selected() {
        when (binding.spinner.selectedItemPosition) {
            0 -> AlertDialog.Builder(binding.root.context).setMessage("Clicado opcion 1")
                .setTitle("Titulo").create().show()
            1 -> AlertDialog.Builder(binding.root.context).setMessage("Clicado opcion 2")
                .setTitle("Titulo").create().show()
            2 -> AlertDialog.Builder(binding.root.context).setMessage("Clicado opcion 3")
                .setTitle("Titulo").create().show()
            3 -> AlertDialog.Builder(binding.root.context).setMessage("Clicado opcion 4")
                .setTitle("Titulo").create().show()
            4 -> AlertDialog.Builder(binding.root.context).setMessage("Clicado opcion 5")
                .setTitle("Titulo").create().show()
            5 -> AlertDialog.Builder(binding.root.context).setMessage("Clicado opcion 6")
                .setTitle("Titulo").create().show()


        }


    }

    private fun itemSeleccionado() {

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                binding.textViewSeleccionado.text = "Elección:  ${view as TextView}.text}"
                binding.textViewID.text = "Id: $id"
                binding.textViewPosicion.text = "Posición: $position"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(requireContext(), "onNothingSelected", Toast.LENGTH_SHORT).show()

            }
        }
    }

}