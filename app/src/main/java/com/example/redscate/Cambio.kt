package com.example.redscate

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class Cambio {
    object BotonesManager {
        fun configurarBotones(
            context: Context,
            button_s: AppCompatButton,
            button_r: AppCompatButton,
            perfil: String,
            constraintLayout: ConstraintLayout,
            imageView3: ImageView
        ) {
            if (perfil != "s") {
                button_r.setBackgroundResource(R.drawable.rounded_button_azul)
                button_r.setTextColor(ContextCompat.getColor(context, R.color.white))
                val newDrawable: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.rescatista_blanco)
                button_r.setCompoundDrawablesWithIntrinsicBounds(newDrawable, null, null, null)

                button_s.setBackgroundResource(R.drawable.rounded_button_blanco)
                button_s.setTextColor(ContextCompat.getColor(context, R.color.text_color))
                val newDrawable_2: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.cruz_gris)
                button_s.setCompoundDrawablesWithIntrinsicBounds(newDrawable_2, null, null, null)

                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.azul_rescatista
                    )
                )
                imageView3.setImageResource(R.drawable.rescatista_blanco)
            } else {
                button_s.setTextColor(ContextCompat.getColor(context, R.color.white))
                button_s.setBackgroundResource(R.drawable.rounded_button_verde)
                val newDrawable_2: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.cruz_blanca)
                button_s.setCompoundDrawablesWithIntrinsicBounds(newDrawable_2, null, null, null)

                button_r.setTextColor(ContextCompat.getColor(context, R.color.text_color))
                button_r.setBackgroundResource(R.drawable.rounded_button_blanco)
                val newDrawable: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.rescatista_gris)
                button_r.setCompoundDrawablesWithIntrinsicBounds(newDrawable, null, null, null)

                constraintLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
                imageView3.setImageResource(R.drawable.cruz_blanca)
            }
        }
        fun configurarParteSuperior(
            context: Context,
            perfil: String,
            constraintLayout: ConstraintLayout,
            imageView3: ImageView
        ) {
            if (perfil != "s") {
                val newDrawable: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.rescatista_blanco)

                val newDrawable_2: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.cruz_gris)

                constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.azul_rescatista
                    )
                )
                imageView3.setImageResource(R.drawable.rescatista_blanco)
            } else {

                val newDrawable_2: Drawable? =
                    ContextCompat.getDrawable(context, R.drawable.cruz_blanca)

                    ContextCompat.getDrawable(context, R.drawable.rescatista_gris)

                constraintLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
                imageView3.setImageResource(R.drawable.cruz_blanca)
            }
        }

    }
}