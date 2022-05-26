package com.example.repaso_examen_final.ejercicios.paso_argumentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.FragmentPAOrigenBinding


class PAOrigenFragment : Fragment() {
    private var _binding: FragmentPAOrigenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPAOrigenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviarDatos.setOnClickListener{

            val persona = Persona(
                binding.textInputEditTextNombre.text.toString(),
                binding.textInputEditTextApellidos.text.toString(),
                binding.textInputEditTextEdad.text.toString().toInt()
            )
            /** Habría que gestionar errores en la inserción de datos, en particular
             * la NumberFormatException que salta si no se introduce un Int para la edad */



            findNavController().navigate(
                PAOrigenFragmentDirections.actionNavPasoArgumentosToNavPasoArgumentos22(persona)
            )
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}