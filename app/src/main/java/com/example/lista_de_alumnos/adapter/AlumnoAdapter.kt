package com.example.lista_de_alumnos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_de_alumnos.Alumno
import com.example.lista_de_alumnos.R

class AlumnoAdapter(private val alumnoLista:List<Alumno>) : RecyclerView.Adapter<AlumnoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlumnoHolder(layoutInflater.inflate(R.layout.item_alumno, parent, false))
    }

    override fun getItemCount(): Int {
        return alumnoLista.size
    }

    override fun onBindViewHolder(holder: AlumnoHolder, position: Int) {
        val item = alumnoLista[position]
        holder.render(item)
    }
}