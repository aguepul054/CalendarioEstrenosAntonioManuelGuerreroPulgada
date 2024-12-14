package com.example.calendarioestrenos


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calendarioestreno.R

class ResultActivity : AppCompatActivity() {

    private lateinit var tv_dateResult:TextView
    private lateinit var tv_estreno:TextView
    private lateinit var tv_estreno2:TextView
    private lateinit var tv_estreno3:TextView

    private lateinit var btnVolver: Button
    private lateinit var iv_anime_1:ImageView
    private lateinit var iv_anime_2:ImageView
    private lateinit var iv_anime_3:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Creamos 3 variables que guardaran lo que le pasamos desde el MainActivity
        val anio = intent.getIntExtra("anio",0);
        val mes = intent.getIntExtra("mes", 0);
        val dia = intent.getIntExtra("dia",0);

        tv_dateResult = findViewById(R.id.tv_dateResult)
        tv_estreno = findViewById(R.id.tv_estreno)
        tv_estreno2 = findViewById(R.id.tv_estreno2)
        tv_estreno3 = findViewById(R.id.tv_estreno3)
        btnVolver = findViewById(R.id.btnVolver)
        iv_anime_1 = findViewById(R.id.iv_anime_1)
        iv_anime_2 = findViewById(R.id.iv_anime_2)
        iv_anime_3 = findViewById(R.id.iv_anime_3)

        //Le ponemos la fecha al TextView
        tv_dateResult.setText("Estrenos el : $anio/$mes/$dia")


        //Aqui hacemos un when para que dependiendo de la fecha ponga 3 imagenes distintas y 3 nombres
        //distintos.
        when(anio){
            2024 -> {
                when(mes){
                   in 1..5 ->{
                       when(dia){
                           in 1..15 -> {
                               iv_anime_1.setImageResource(R.drawable.ic_anime4)
                               tv_estreno.setText(R.string.estreno4)
                               tv_estreno.setTextColor(resources.getColor(R.color.anime4,null))

                               iv_anime_2.setImageResource(R.drawable.ic_anime5)
                               tv_estreno2.setText(R.string.estreno5)
                               tv_estreno2.setTextColor(resources.getColor(R.color.anime5,null))


                               iv_anime_3.setImageResource(R.drawable.ic_anime6)
                               tv_estreno3.setText(R.string.estreno6)
                               tv_estreno3.setTextColor(resources.getColor(R.color.anime6,null))
                           }
                           in 15..31 -> {
                               iv_anime_1.setImageResource(R.drawable.ic_anime1)
                               tv_estreno.setText(R.string.estreno1)

                               iv_anime_2.setImageResource(R.drawable.ic_anime2)
                               tv_estreno2.setText(R.string.estreno2)

                               iv_anime_3.setImageResource(R.drawable.ic_anime3)
                               tv_estreno3.setText(R.string.estreno3)

                           }
                       }
                   }
                   in 6..12 -> {
                       when(dia){
                           in 1..15 -> {
                               iv_anime_1.setImageResource(R.drawable.ic_anime1)
                               tv_estreno.setText(R.string.estreno1)

                               iv_anime_2.setImageResource(R.drawable.ic_anime2)
                               tv_estreno2.setText(R.string.estreno2)

                               iv_anime_3.setImageResource(R.drawable.ic_anime3)
                               tv_estreno3.setText(R.string.estreno3)
                           }
                           in 15..31 -> {
                               iv_anime_1.setImageResource(R.drawable.ic_anime4)
                               tv_estreno.setText(R.string.estreno4)
                               tv_estreno.setTextColor(resources.getColor(R.color.anime4,null))

                               iv_anime_2.setImageResource(R.drawable.ic_anime5)
                               tv_estreno2.setText(R.string.estreno5)
                               tv_estreno2.setTextColor(resources.getColor(R.color.anime5,null))


                               iv_anime_3.setImageResource(R.drawable.ic_anime6)
                               tv_estreno3.setText(R.string.estreno6)
                               tv_estreno3.setTextColor(resources.getColor(R.color.anime6,null))

                           }
                       }
                   }
                }
            }
        }
        setListeners()
    }

    private fun setListeners(){
        btnVolver.setOnClickListener{
           onBackPressedDispatcher.onBackPressed()
        }
    }
}


