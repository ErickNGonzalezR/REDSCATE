package com.example.redscate

import android.annotation.SuppressLint
import android.provider.Settings
import android.content.Context

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redscate.Cambio.BotonesManager.configurarBotones


class Perfil : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        // Obtienes la referencia al TextView (asegúrate de que sea un TextView o el tipo correcto de vista)
        val nombre: TextView = findViewById(R.id.nombre_apellido)
        val edad: TextView = findViewById(R.id.edad_2)
        val rh: TextView = findViewById(R.id.rh_2)
        val name: TextView = findViewById(R.id.nameC)
        val parentesco: TextView = findViewById(R.id.relationship)
        val telefono: TextView = findViewById(R.id.numberPhone)
        val constraintLayout =
            findViewById<ConstraintLayout>(R.id.constraintLayout) // Asegúrate de asignar el ID a tu ConstraintLayout
        val imageView3 = findViewById<ImageView>(R.id.imageView3)

        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString("edad", "")
        editor.putString("rh", "")
        editor.putString("perfil", "")
        editor.putString("nombreC", "")
        editor.putString("parentesco", "")
        editor.putString("telefono", "")
        editor.apply() // Aplicar los cambios*/

        nombre.text = sharedPreferences.getString("nombre", "Valor por defecto")
        val age = sharedPreferences.getString("edad", "Valor por defecto")
        if (age != "") {

            // Obtener los LayoutParams del TextView
            val layoutParams = edad.layoutParams as ConstraintLayout.LayoutParams

            // Cambiar la altura a wrap_content
            layoutParams.height =
                ConstraintLayout.LayoutParams.WRAP_CONTENT // Cambia de 0dp a wrap_content

            // Aplicar los nuevos LayoutParams al TextView
            edad.layoutParams = layoutParams
        }
        edad.text = age

        val nombreC = sharedPreferences.getString("nombreC", "Valor por defecto")
        if (nombreC != "") {

            // Obtener los LayoutParams del TextView
            val layoutParams = name.layoutParams as ConstraintLayout.LayoutParams

            // Cambiar la altura a wrap_content
            layoutParams.height =
                ConstraintLayout.LayoutParams.WRAP_CONTENT // Cambia de 0dp a wrap_content

            // Aplicar los nuevos LayoutParams al TextView
            name.layoutParams = layoutParams
        }
        name.text = nombreC
        val rH = sharedPreferences.getString("rh", "Valor por defecto")
        if (rH != "") {

            // Obtener los LayoutParams del TextView
            val layoutParams = rh.layoutParams as ConstraintLayout.LayoutParams

            // Cambiar la altura a wrap_content
            layoutParams.height =
                ConstraintLayout.LayoutParams.WRAP_CONTENT // Cambia de 0dp a wrap_content

            // Aplicar los nuevos LayoutParams al TextView
            rh.layoutParams = layoutParams
        }
        rh.text = rH
        val parentescoC = sharedPreferences.getString("parentesco", "Valor por defecto")
        if (parentescoC != "") {

            // Obtener los LayoutParams del TextView
            val layoutParams = parentesco.layoutParams as ConstraintLayout.LayoutParams

            // Cambiar la altura a wrap_content
            layoutParams.height =
                ConstraintLayout.LayoutParams.WRAP_CONTENT // Cambia de 0dp a wrap_content

            // Aplicar los nuevos LayoutParams al TextView
            parentesco.layoutParams = layoutParams
        }
        parentesco.text = parentescoC
        val telefonoC = sharedPreferences.getString("telefono", "Valor por defecto")
        if (telefonoC != "") {

            // Obtener los LayoutParams del TextView
            val layoutParams = telefono.layoutParams as ConstraintLayout.LayoutParams

            // Cambiar la altura a wrap_content
            layoutParams.height =
                ConstraintLayout.LayoutParams.WRAP_CONTENT // Cambia de 0dp a wrap_content

            // Aplicar los nuevos LayoutParams al TextView
            telefono.layoutParams = layoutParams
        }
        telefono.text = telefonoC

        var perfil = sharedPreferences.getString("perfil", "Valor por defecto")

        perfil = perfil.toString()
        val button_s = findViewById<AppCompatButton>(R.id.button_sobreviviente)
        val button_r = findViewById<AppCompatButton>(R.id.button_rescatista)

        configurarBotones(this, button_s, button_r, perfil, constraintLayout, imageView3)


        // Inicio de la configuracion de los Botones del nav bar
        val buttonperfil = findViewById<AppCompatButton>(R.id.button_perfil)
        // Obtener el drawable
        val homeDrawable = ContextCompat.getDrawable(this, R.drawable.perfil_rojo)

        // Cambiar el drawable en la posición superior
        buttonperfil.setCompoundDrawablesWithIntrinsicBounds(
            null,  // izquierda
            homeDrawable, // arriba (drawableTop)
            null,  // derecha
            null   // abajo
        )

        // Cambiar el color del texto a rojo
        buttonperfil.setTextColor(Color.parseColor("#fb0e1b"))
        // Configura el listener para el botón

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
        // Encuentra el botón por ID
        val buttonRadar = findViewById<AppCompatButton>(R.id.button_radar)

        // Configura el listener para el botón
        buttonRadar.setOnClickListener {
            // Crea el intent para dirigir a nav_bar Activity
            val intent = Intent(this, Radar::class.java)
            startActivity(intent) // Inicia la actividad nav_bar
        }
        // Fin dela  configuracion de los botones del nav bar
        val buttonConfigurar = findViewById<AppCompatButton>(R.id.button_configurar)

        // Agrega el listener al botón
        buttonConfigurar.setOnClickListener {
            // Navegar a otra actividad
            val intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }

        if (perfil != "s") {
            val perfilrescatista = findViewById<ConstraintLayout>(R.id.perfil_rescatista)
            perfilrescatista.visibility = View.VISIBLE
        } else {
            val perfilsobreviviente = findViewById<ConstraintLayout>(R.id.perfil_sobreviviente)
            perfilsobreviviente.visibility = View.VISIBLE
        }


        /*when (botonPrincipal) {
            1 -> when (botonSecundario) {
                1 ->
                    2 ->
                    3 ->
                        4 ->
            }

            2 ->
                3

            ->
                4

            ->
                5

            ->
                6

            ->
                7

            ->
        }
    }
*/

}
}
