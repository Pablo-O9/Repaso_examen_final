package com.example.repaso_examen_final.ejercicios.recicleview

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.Elemento3Binding
import com.example.repaso_examen_final.databinding.FragmentRecyclerviewEj1FragementBinding

class RecyclerviewEj1Fragement : Fragment() {

    private var _binding: FragmentRecyclerviewEj1FragementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRecyclerviewEj1FragementBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonEj4.setOnClickListener {
            cargarLista()
            binding.recyclerView.visibility=View.VISIBLE
        }


    }
    private fun cargarLista() {
        val lenguajes: MutableList<LenguajeProg> = ArrayList()
        lenguajes.add(LenguajeProg("Java", R.drawable.java))
        lenguajes.add(LenguajeProg("Kotlin", R.drawable.kotlin))
        lenguajes.add(LenguajeProg("JavaScript", R.drawable.javascript))
        lenguajes.add(LenguajeProg("Swift", R.drawable.swift))
        lenguajes.add(LenguajeProg("Python", R.drawable.python))
        lenguajes.add(LenguajeProg("PHP", R.drawable.php))
        lenguajes.add(LenguajeProg("C#", R.drawable.csharp))
        lenguajes.add(LenguajeProg("Go", R.drawable.go))
        lenguajes.add(LenguajeProg("Rust", R.drawable.rust))

        with(binding.recyclerView) {
            adapter = CustomAdapter(lenguajes)
            layoutManager = LinearLayoutManager(requireContext())
        }

    }
    class CustomAdapter(private val listadoDatos: MutableList<LenguajeProg>) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding: Elemento3Binding) : RecyclerView.ViewHolder(binding.root) {
            val mView = binding.root
            val textView = binding.textViewAutor
            val imageView = binding.imageView

            init {
                binding.root.setOnClickListener {
                    Toast.makeText(
                        binding.root.context,
                        "Has elegido: " + textView.text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        /** Método al que se llama cada vez que se crea uno de los elementos de la lista. */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            Elemento3Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = listadoDatos[position].nombre
            holder.imageView.setImageResource(listadoDatos[position].idImagen)

            with(holder) {
                if (position % 2 == 0) { // Si la posición de la fila es par
                    mView.setBackgroundColor(Color.CYAN)
                    textView.setTextColor(Color.BLUE)
                } else { // Si la posición es impar
                    mView.setBackgroundColor(Color.TRANSPARENT)
                    textView.setTextColor(Color.BLUE)
                }
            }
        }

        override fun getItemCount() = listadoDatos.size
        }
    }