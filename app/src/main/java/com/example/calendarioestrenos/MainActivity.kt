package com.example.calendarioestrenos

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calendarioestreno.R

class MainActivity : AppCompatActivity() {
    private lateinit var calendar:Calendar
    private lateinit var buttonDatePicker:Button
    private lateinit var textViewDate:TextView
    private lateinit var btnNext:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonDatePicker = findViewById(R.id.buttonDatePicker)
        textViewDate = findViewById(R.id.textViewDate)
        btnNext = findViewById(R.id.btnNext)

        setListeners()
    }

    private fun setListeners(){
        // Configuración del calendario
        calendar = Calendar.getInstance()

        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)

        // Evento del botón para mostrar el DatePickerDialog
        buttonDatePicker.setOnClickListener {

            // Creamos el DatePickerDialog y en mi caso lo customizo con un style personalizado
            val datePickerDialog = DatePickerDialog(
                this, R.style.CustomDatePickerDialog, { _, selectedYear, selectedMonth, selectedDay ->
                    // Actualizamos las variables con la fecha seleccionada
                    year = selectedYear
                    // Se le coloca el +1 porque empieza a contar por 0
                    month = selectedMonth+1
                    day = selectedDay

                    // Actualizamos el TextView con la fecha seleccionada
                    textViewDate.text = "Fecha seleccionada: $day/${month}/$year"
                }, year, month, day
            )

            // Mostrar el DatePickerDialog
            datePickerDialog.show()
        }
        //Le añadimos un evento al boton para pasar al ResultActivity pasandole el año, mes y dia
        //que hemos puesto anteriormente
        btnNext.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("anio",year)
            intent.putExtra("mes", month)
            intent.putExtra("dia", day)

            startActivity(intent)
        }
    }
}