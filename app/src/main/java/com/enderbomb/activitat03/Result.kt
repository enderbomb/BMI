package com.enderbomb.activitat03

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class Result : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val back: ImageView = findViewById(R.id.back)
        val calc: MaterialButton = findViewById(R.id.calc)
        val height = intent.getDoubleExtra("height", 0.0)
        val weight = intent.getDoubleExtra("weight", 0.0)
        val valor: TextView = findViewById(R.id.valor)
        val estado: TextView = findViewById(R.id.estado)
        val estado2: TextView = findViewById(R.id.estado2)
        back.setOnClickListener {
            finish()
        }
        calc.setOnClickListener {
            finish()
        }
        try {
            val bmi: Double = (weight * 703) / (height * height)
            valor.text = String.format("%.2f", bmi)

            when {
                bmi < 18.5 -> {
                    estado.text = "UNDERWEIGHT"
                    estado.setTextColor(Color.BLUE)
                    estado2.text = "Underweight"
                }
                bmi < 25.0 -> {
                    estado.text = "NORMAL"
                    estado.setTextColor(Color.GREEN)
                    estado2.text = "Normal"
                }
                bmi < 30.0 -> {
                    estado.text = "OVERWEIGHT"
                    estado.setTextColor(Color.YELLOW)
                    estado2.text = "Overweight"
                }
                else -> {
                    estado.text = "OBESE"
                    estado.setTextColor(Color.RED)
                    estado2.text = "Obese"
                }
            }
        } catch (e: Exception) {
            print("$e")
        }
    }
}