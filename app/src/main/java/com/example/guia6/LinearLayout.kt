package com.example.guia6

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LinearLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_linear_layout)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val correo = findViewById<EditText>(R.id.input_usuario)
        val contrasena = findViewById<EditText>(R.id.input_contrasena)

        findViewById<android.view.View>(R.id.boton_iniciar_sesion).setOnClickListener {
            when {
                correo.text.isNullOrBlank() -> correo.error = getString(R.string.campo_requerido)
                contrasena.text.isNullOrBlank() -> contrasena.error = getString(R.string.campo_requerido)
                else -> Toast.makeText(this, R.string.sesion_iniciada, Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<android.view.View>(R.id.btnSalir).setOnClickListener {
            finish()
        }
    }
}
