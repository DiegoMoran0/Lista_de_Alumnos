package com.example.lista_de_alumnos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AgregarAlumnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_alumno)

        // Referenciar los campos del formulario
        val nombreInput = findViewById<EditText>(R.id.etxtNombre)
        val cuentaInput = findViewById<EditText>(R.id.etxtCuenta)
        val correoInput = findViewById<EditText>(R.id.etxtCorreo)
        val imagenInput = findViewById<EditText>(R.id.etxtImagen)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        // Acción al presionar el botón "Agregar"
        btnAgregar.setOnClickListener {
            // Recoger los valores de los campos
            val nombre = nombreInput.text.toString()
            val cuenta = cuentaInput.text.toString()
            val correo = correoInput.text.toString()
            val imagen = imagenInput.text.toString()

            // Crear un Intent para enviar los datos de regreso a MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("NOMBRE", nombre)
            resultIntent.putExtra("CUENTA", cuenta)
            resultIntent.putExtra("CORREO", correo)
            resultIntent.putExtra("IMAGEN", imagen)
            setResult(RESULT_OK, resultIntent)
            finish() // Finaliza esta actividad y regresa a MainActivity
        }
    }
}
