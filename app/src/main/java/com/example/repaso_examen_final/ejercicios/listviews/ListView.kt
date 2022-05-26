package com.example.repaso_examen_final.ejercicios.listviews

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.FragmentListViewBinding


class ListView : Fragment() {
    private var _binding: FragmentListViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.array_paises,
            R.layout.layout_bonito
        ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

        binding.lista01.apply { this.adapter = adapter }
            .apply {
                setOnItemClickListener { _, view, _, _ ->
                    showNotification("Click en ${(view as TextView).text}")
                }
            }.apply {
                setOnItemLongClickListener { parent, view, position, id ->
                    showNotification(
                        """OnItemSelectedListener:
                            ${parent.selectedItem}
                            ${parent.getItemAtPosition(position)}
                            ${(view as TextView).text}
                            position = $position
                            id = $id
                            """.trimIndent()
                    )
                    true
                }
            }

    }

    private fun showNotification(mensaje: String) {
        AlertDialog.Builder(requireContext()).setMessage(mensaje).setTitle("Alerta")
            .create().show()
    }
}


