package com.example.redscate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class nav_bar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nav_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Encuentra el botón por ID
        val buttonHome = findViewById<AppCompatButton>(R.id.button_home)

        // Configura el listener para el botón
        buttonHome.setOnClickListener {
            // Crea el intent para dirigir a nav_bar Activity
            val intent = Intent(this, Home::class.java)
            startActivity(intent) // Inicia la actividad nav_bar
        }
        // Encuentra el botón por ID
        val buttonPerfil = findViewById<AppCompatButton>(R.id.button_perfil)

        // Configura el listener para el botón
        buttonPerfil.setOnClickListener {
            // Crea el intent para dirigir a nav_bar Activity
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent) // Inicia la actividad nav_bar
        }
        // Encuentra el botón por ID
        val buttonRadar = findViewById<AppCompatButton>(R.id.button_radar)

        // Configura el listener para el botón
        buttonRadar.setOnClickListener {
            // Crea el intent para dirigir a nav_bar Activity
            val intent = Intent(this, Radar::class.java)
            startActivity(intent) // Inicia la actividad nav_bar
        }
    }
}