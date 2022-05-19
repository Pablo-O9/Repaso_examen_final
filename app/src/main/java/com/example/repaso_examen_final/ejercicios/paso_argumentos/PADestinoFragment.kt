package com.example.repaso_examen_final.ejercicios.paso_argumentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.repaso_examen_final.databinding.FragmentPADestinoBinding


class PADestinoFragment : Fragment() {

    private var _binding: FragmentPADestinoBinding? = null
    private val binding get() = _binding!!

   private val args: PADestinoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPADestinoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRecepcion.text = args.persona.toString()

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}