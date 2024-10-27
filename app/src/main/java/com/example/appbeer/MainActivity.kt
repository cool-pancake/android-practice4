package com.example.appbeer

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.typeOf

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

        val btnBeer: Button = findViewById(R.id.btnBeer)
        val tvBeer: TextView = findViewById(R.id.tvBeer)
        val spinnerBtn: Spinner = findViewById(R.id.spinBeer)

        btnBeer.setOnClickListener {
            val type = spinnerBtn.selectedItem
            tvBeer.text = "Тип пива: $type"
            val type_res = when(tvBeer.text) {
                "Светлое" -> R.drawable.svetloe
                "Тёмное" -> R.drawable.temnoe
                "Ржанное" -> R.drawable.rjanoe
                "Сладкое" -> R.drawable.sladkoe
                "Горькое" -> R.drawable.gorkoe
                else -> R.drawable.dead_pivo
            }

            val imgBeer: ImageView = findViewById(R.id.imgBeer)
            imgBeer.setImageResource(type_res)
        }
    }
}