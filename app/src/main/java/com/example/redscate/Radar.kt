package com.example.redscate

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redscate.Cambio.BotonesManager.configurarBotones
import com.example.redscate.Cambio.BotonesManager.configurarParteSuperior

class Radar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        var perfil = sharedPreferences.getString("perfil", "Valor por defecto")

        // Inicio de la configuracion de los Botones del nav bar
        // Encuentra el botón por ID
        val buttonradar = findViewById<AppCompatButton>(R.id.button_radar)
        // Obtener el drawable
        val homeDrawable = ContextCompat.getDrawable(this, R.drawable.radar_rojo)

        // Cambiar el drawable en la posición superior
        buttonradar.setCompoundDrawablesWithIntrinsicBounds(
            null,  // izquierda
            homeDrawable, // arriba (drawableTop)
            null,  // derecha
            null   // abajo
        )

        // Cambiar el color del texto a rojo
        buttonradar.setTextColor(Color.parseColor("#fb0e1b"))
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
        // Configura el listener para el botón

        val buttonHome = findViewById<AppCompatButton>(R.id.button_home)

        // Configura el listener para el botón
        buttonHome.setOnClickListener {
            // Crea el intent para dirigir a nav_bar Activity
            val intent = Intent(this, Home::class.java)
            startActivity(intent) // Inicia la actividad nav_bar
        }
        // Fin dela  configuracion de los botones del nav bar
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)


        perfil = perfil.toString()
        configurarParteSuperior(this,perfil, constraintLayout, imageView3)

    }
}