package com.example.repaso_examen_final.ejercicios.paso_argumentos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persona(
    private val nombre:String?,private val apellidos:String?, private val edad:Int?
):Parcelable {
    override fun toString()="Recibiendo datos de $nombre $apellidos, cuya edad es $edad años"
}
