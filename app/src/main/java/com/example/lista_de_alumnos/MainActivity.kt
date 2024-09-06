package com.example.lista_de_alumnos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_de_alumnos.adapter.AlumnoAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycleView()
    }

    private fun initRecycleView(){
        val recycleView = findViewById<RecyclerView>(R.id.recyclerAlumno)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = AlumnoAdapter(AlumnoProvider.alumnoLista)
    }
}