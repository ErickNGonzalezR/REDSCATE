package com.example.redscate

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicio de la configuracion de los Botones del nav bar


        // Encuentra el botón por ID
        val buttonHome = findViewById<AppCompatButton>(R.id.button_home)
// Obtener el drawable
        val homeDrawable = ContextCompat.getDrawable(this, R.drawable.home)

// Cambiar el drawable en la posición superior
        buttonHome.setCompoundDrawablesWithIntrinsicBounds(
            null,  // izquierda
            homeDrawable, // arriba (drawableTop)
            null,  // derecha
            null   // abajo
        )

// Cambiar el color del texto a rojo
        buttonHome.setTextColor(Color.parseColor("#fb0e1b"))

        // Configura el listener para el botón
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

        // Fin dela  configuracion de los botones del nav bar
    }
}