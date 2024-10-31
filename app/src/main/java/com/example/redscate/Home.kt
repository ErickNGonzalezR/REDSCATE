package com.example.redscate

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
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

        val button_s = findViewById<AppCompatButton>(R.id.button_sobreviviente)
        val button_r = findViewById<AppCompatButton>(R.id.button_rescatista)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)

        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        var perfil = sharedPreferences.getString("perfil", "Valor por defecto")

        perfil = perfil.toString()
        configurarBotones(this, button_s, button_r, perfil, constraintLayout, imageView3)
        /*
        * Inicio de la configuracion para guardar elementos en el dispocitivo movil
        *
        * */

        // Función que obtiene el nombre del dispositivo
        fun getDeviceName(context: Context): String {
            return Settings.Global.getString(context.contentResolver, "device_name")
        }

        val nombreA = getDeviceName(this)

        val editor = sharedPreferences.edit()
        val nombre = sharedPreferences.getString("nombre", nombreA)
        val edad = sharedPreferences.getString("edad", "10")
        val profile = sharedPreferences.getString("perfil", "s")
        val nameC = sharedPreferences.getString("nombreC", "")
        val parentesco = sharedPreferences.getString("parentesco", "")
        val telefono = sharedPreferences.getString("telefono", "")
        val codigoRescatista = sharedPreferences.getString("codigoRescatista", "")
        editor.apply() // Aplicar los cambios*/
        /*
                if(nombre  != nombreA){
                    if ()
                    editor.putString("edad", "10")
                    editor.putString("rh", "j")
                    editor.putString("perfil", "s")
                    editor.putString("nombreC", "hgj")
                    editor.putString("parentesco", "jgh")
                    editor.putString("telefono", "jgh")
                }else
                editor.putString("nombre", nombreA)
                editor.putString("edad", "10")
                editor.putString("rh", "j")
                editor.putString("perfil", "s")
                editor.putString("nombreC", "hgj")
                editor.putString("parentesco", "jgh")
                editor.putString("telefono", "jgh")

                editor.apply() // Aplicar los cambios*/
        //inicio de la logica del popUp
        // ConstraintLayout que funciona como botón para mostrar el popup
        val showPopupLayout = findViewById<ConstraintLayout>(R.id.button_reaccion_campo)
        showPopupLayout.setOnClickListener {
            showPopupWindow(it)
        }
    }

    private fun showPopupWindow(view: View) {
        // Inflar el layout del popup
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_template_cards, null)

        // Crear el PopupWindow
        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        // Configurar el fondo desenfocado
        val blurBackground = findViewById<View>(R.id.blur_background)
        blurBackground.visibility = View.VISIBLE

        // Configurar el PopupWindow para cerrarse al hacer clic fuera de él
        popupWindow.isOutsideTouchable = true
        popupWindow.isFocusable = true
        popupWindow.setOnDismissListener {
            blurBackground.visibility = View.GONE // Ocultar el fondo desenfocado al cerrar el popup
        }

        // Declarar botonSecundario como var
        var botonSecundario = 1

        // Obtener referencias a las vistas dentro del popup
        val subTitulo = popupView.findViewById<TextView>(R.id.subtitle)
        val numero = popupView.findViewById<TextView>(R.id.number_card)
        val texto = popupView.findViewById<TextView>(R.id.texts_cards)
        val imagen = popupView.findViewById<ImageView>(R.id.images_cards)

        // Configurar el contenido inicial del popup
        botonSecundario = updatePopupContent(botonSecundario, subTitulo, numero, texto, imagen)

        // Configurar el botón de cerrar
        val buttonClose = popupView.findViewById<ImageButton>(R.id.button_cerrar)
        buttonClose.setOnClickListener {
            popupWindow.dismiss()
        }

        // Configurar los botones "Atrás" y "Siguiente"
        val buttonAtras = popupView.findViewById<AppCompatButton>(R.id.button_atras)
        val buttonSiguiente = popupView.findViewById<AppCompatButton>(R.id.button_siguiente)

        buttonAtras.setOnClickListener {
            botonSecundario-- // Decrementar el número
            botonSecundario = updatePopupContent(botonSecundario, subTitulo, numero, texto, imagen)
        }

        buttonSiguiente.setOnClickListener {
            botonSecundario++ // Aumentar el número
            botonSecundario = updatePopupContent(botonSecundario, subTitulo, numero, texto, imagen)
        }

        // Mostrar el popup en el centro de la pantalla
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }

    // Método para actualizar el contenido del popup
    private fun updatePopupContent(
        botonSecundario: Int,
        subTitulo: TextView,
        numero: TextView,
        texto: TextView,
        imagen: ImageView
    ): Int { // Cambiar el tipo de retorno a Int
        when (botonSecundario) {
            1 -> {
                subTitulo.text = ""
                numero.text = "1."
                texto.text = "Evita las zonas con pendientes, los filos de montaña y valles estrechos, ya que el aire caliente tiende a ascender."
                imagen.setImageResource(R.drawable.reaccion_campo_image_1)
            }
            2 -> {
                subTitulo.text = ""
                numero.text = "2."
                texto.text = "Evita refugiarte en pozos o cuevas, ya que el oxigeno se te podría acabar rápidamente."
                imagen.setImageResource(R.drawable.reaccion_campo_image_2)
            }
            3 -> {
                subTitulo.text = "TENER EN CUENTA"
                numero.text = "3."
                texto.text = "No realices fogatas ni asados en temporada de verano ya que el pasto estará seco y subirá el riesgo de provocar un incendio forestal."
                imagen.setImageResource(R.drawable.reaccion_campo_image_3)
            }
            4 -> {
                subTitulo.text = "TENER EN CUENTA"
                numero.text = "4."
                texto.text = "No arrojes las colillas de los cigarrillos en zonas verdes. Esto puede expandir aún más el incendio en caso de que ocurra."
                imagen.setImageResource(R.drawable.reaccion_campo_image_4)
                return 0
            }
            else -> {
                return 0 // Retornar 1 si es mayor que 4
            }
        }
        return botonSecundario // Retornar el valor original si no ha cambiado
    }


}

