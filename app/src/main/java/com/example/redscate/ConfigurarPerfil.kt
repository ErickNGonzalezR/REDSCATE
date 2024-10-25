package com.example.redscate

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redscate.Cambio.BotonesManager.configurarParteSuperior

class ConfigurarPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configurar_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinnerPerfil: Spinner = findViewById(R.id.profile)
        val itemsPerfil = arrayOf("Rescatista", "Sobreviviente") // Corregí la ortografía aquí
        val adapterPerfile = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsPerfil)
        adapterPerfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPerfil.adapter = adapterPerfile

        // Paso 3.4: Configurar un listener para manejar la selección
        // Variable global para almacenar el valor seleccionado
        var perfilSeleccionado: String? = null

        spinnerPerfil.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Guarda el valor seleccionado en la variable
                perfilSeleccionado = parent.getItemAtPosition(position).toString()

                // Muestra un Toast con el valor seleccionado
                Toast.makeText(
                    applicationContext,
                    "Seleccionaste: $perfilSeleccionado",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Maneja el caso cuando no se selecciona nada (opcional)
            }
        }
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        var perfil = sharedPreferences.getString("perfil", "Valor por defecto")
        perfil = perfil.toString()

        if (perfil != "s"){
            val perfilrescatista = findViewById<ConstraintLayout>(R.id.perfil_rescatista)
            perfilrescatista.visibility =View.VISIBLE
        }else{
            val perfilsobreviviente = findViewById<ConstraintLayout>(R.id.perfil_sobreviviente)
            perfilsobreviviente.visibility =View.VISIBLE
        }
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)


        perfil = perfil.toString()
        configurarParteSuperior(this,perfil, constraintLayout, imageView3)


    }
}