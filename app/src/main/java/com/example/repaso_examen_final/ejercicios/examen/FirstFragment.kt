package com.example.repaso_examen_final.ejercicios.examen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val lista: MutableList<String> = ArrayList()
//
//        lista.add(0, "Genero:")
//        lista.add(4, "Varios")
//
//        binding.spinnerGeneros.adapter = ArrayAdapter(
//            requireActivity(),
//            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//            lista
//        )

        binding.btnSiguiente.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}