package com.example.lista_de_alumnos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_de_alumnos.adapter.AlumnoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var alumnoAdapter: AlumnoAdapter
    private val REQUEST_CODE_ADD_ALUMNO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el RecyclerView
        initRecycleView()

        // Acción al presionar el botón flotante
        val fab = findViewById<FloatingActionButton>(R.id.fabAgregarAlumno)
        fab.setOnClickListener {
            // Crear un Intent para abrir la actividad AgregarAlumnoActivity
            val intent = Intent(this, AgregarAlumnoActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_ALUMNO)
        }
    }

    private fun initRecycleView() {
        val recycleView = findViewById<RecyclerView>(R.id.recyclerAlumno)
        recycleView.layoutManager = LinearLayoutManager(this)

        // Usar la lista de alumnos inicial
        alumnoAdapter = AlumnoAdapter(AlumnoProvider.alumnoLista.toMutableList())
        recycleView.adapter = alumnoAdapter
    }

    // Recibir los datos del nuevo alumno cuando se regresa de AgregarAlumnoActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_ALUMNO && resultCode == RESULT_OK) {
            // Obtener los datos del alumno desde el Intent
            val nombre = data?.getStringExtra("NOMBRE")
            val cuenta = data?.getStringExtra("CUENTA")
            val correo = data?.getStringExtra("CORREO")
            val imagen = data?.getStringExtra("IMAGEN")

            // Crear un nuevo alumno y agregarlo a la lista
            if (nombre != null && cuenta != null && correo != null && imagen != null) {
                val nuevoAlumno = Alumno(nombre, cuenta, imagen, correo)
                alumnoAdapter.addAlumno(nuevoAlumno)
            }
        }
    }
}
