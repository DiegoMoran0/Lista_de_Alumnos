package com.example.lista_de_alumnos.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lista_de_alumnos.Alumno
import com.example.lista_de_alumnos.R

class AlumnoHolder(view:View):RecyclerView.ViewHolder(view) {

    val nombre = view.findViewById<TextView>(R.id.tvAlumnoNombre)
    val cuenta = view.findViewById<TextView>(R.id.tvAlumnoCuenta)
    val correo = view.findViewById<TextView>(R.id.tvAlumnoCorreo)
    val imagen = view.findViewById<ImageView>(R.id.ivAlumnoFoto)

    fun render(alumnoModel: Alumno){
        nombre.text = alumnoModel.Nombre
        cuenta.text = alumnoModel.Cuenta
        correo.text = alumnoModel.Correo
        Glide.with(imagen.context).load(alumnoModel.Imagen).into(imagen)

    }
}