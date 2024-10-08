package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //animacion de la onda
        val imageViewDer: ImageView = findViewById(R.id.onda_derecha)
        val shake: Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
        imageViewDer.startAnimation(shake)

        val imageViewIz: ImageView = findViewById(R.id.onda_izquierda)
        imageViewIz.startAnimation(shake)

        val textSos: TextView = findViewById(R.id.sos)
        textSos.startAnimation(shake)
        //fin de animacion de onda

        // Inicio de la configuracion de los Botones del nav bar
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
        // Fin dela  configuracion de los botones del nav bar

        val customButton: LinearLayout = findViewById(R.id.boton_sos)
        customButton.setOnClickListener {
            // Abrir una nueva pantalla (actividad)
            val intent = Intent(this, Radar::class.java)
            startActivity(intent)
        }
    }
}
