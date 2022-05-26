package com.example.repaso_examen_final.ejercicios.examen

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repaso_examen_final.databinding.ElementoExBinding

class CustomAdapter2(private val listadoDatos: MutableList<Album>) :
    RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {

    /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
    class ViewHolder(binding: ElementoExBinding) : RecyclerView.ViewHolder(binding.root) {
        val mView = binding.root
        val textViewAutor = binding.textViewAutor
        val imageView = binding.imageView
        val textViewCancion = binding.textViewCancion
        val borrar = binding.btnDel
        val info = binding.btnInfo

        init {

        }

    }

    /** Método al que se llama cada vez que se crea uno de los elementos de la lista. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ElementoExBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
     * cada elemento */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewAutor.text = listadoDatos[position].autor
        holder.textViewCancion.text = listadoDatos[position].Cancion
        holder.imageView.setImageResource(listadoDatos[position].idImagen)
        holder.borrar.setOnClickListener { borrar(position) }
        holder.info.setOnClickListener { info(position, holder.mView.context) }

        with(holder) {
            if (position % 2 == 0) { // Si la posición de la fila es par
                mView.setBackgroundColor(Color.CYAN)
                textViewCancion.setTextColor(Color.BLACK)
                textViewAutor.setTextColor(Color.BLACK)
            } else { // Si la posición es impar
                mView.setBackgroundColor(Color.TRANSPARENT)
                textViewCancion.setTextColor(Color.BLACK)
                textViewAutor.setTextColor(Color.BLACK)
            }
        }
    }

    private fun borrar(position: Int) {
        listadoDatos.remove(listadoDatos[position]);
        notifyDataSetChanged();
    }

    private fun info(position: Int, context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(listadoDatos[position].Cancion + " - " + listadoDatos[position].autor)
        builder.setMessage(listadoDatos[position].descr)
        builder.setNegativeButton("Cerrrar", { dialoInterface: DialogInterface, i: Int -> })
        builder.show()
    }

    override fun getItemCount() = listadoDatos.size


}