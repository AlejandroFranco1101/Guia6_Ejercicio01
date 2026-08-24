package com.example.guia6

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = findViewById<EditText>(R.id.inputNombreRegistro)
        val apellido = findViewById<EditText>(R.id.inputApellidoRegistro)
        val correo = findViewById<EditText>(R.id.inputCorreoRegistro)
        val contrasena = findViewById<EditText>(R.id.inputContrasenaRegistro)
        val genero = findViewById<RadioGroup>(R.id.grupoGenero)
        val terminos = findViewById<CheckBox>(R.id.aceptarTerminos)

        findViewById<android.view.View>(R.id.botonRegistrar).setOnClickListener {
            when {
                nombre.text.isNullOrBlank() -> nombre.error = getString(R.string.campo_requerido)
                apellido.text.isNullOrBlank() -> apellido.error = getString(R.string.campo_requerido)
                correo.text.isNullOrBlank() -> correo.error = getString(R.string.campo_requerido)
                contrasena.text.isNullOrBlank() -> contrasena.error = getString(R.string.campo_requerido)
                genero.checkedRadioButtonId == -1 -> Toast.makeText(
                    this,
                    R.string.selecciona_genero,
                    Toast.LENGTH_SHORT
                ).show()
                !terminos.isChecked -> Toast.makeText(
                    this,
                    R.string.acepta_terminos_aviso,
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(this, R.string.registro_exitoso, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
