package com.example.repaso_examen_final.ejercicios.recicleview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.FragmentMainBinding
import java.lang.RuntimeException


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lista
            .apply {
                adapter = ArrayAdapter.createFromResource(
                    requireContext(),
                    R.array.ejemplos,
                    android.R.layout.simple_list_item_1
                )
                onItemClickListener = mainOnItemClickListener
            }


    }
    object mainOnItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Log.i("---","""OnItemSelectedListener:
                parent.selectedItem = ${parent?.selectedItem}
                parent?.getItemAtPosition(position) = ${parent?.getItemAtPosition(position)}
                (view as TextView).text = ${(view as TextView).text}
                position = $position
                id = $id
                """.trimIndent())

            parent?.findNavController()?.navigate(
                when (position) {
                    0 -> MainFragmentDirections.actionNavRecycleViewToRecyclerviewEj1Fragement()
                    else -> throw RuntimeException("Ejemplo no existente")
                }
            )
        }

    }
}