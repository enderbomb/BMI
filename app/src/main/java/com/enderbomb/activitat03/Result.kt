package com.enderbomb.activitat03

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var calc: MaterialButton = findViewById(R.id.calc)
        var home = intent.getBooleanExtra("home", false)
        var dona = intent.getBooleanExtra("dona", false)
        var height = intent.getIntExtra("height", 0)
        var weight = intent.getIntExtra("weight", 0)
        var age = intent.getIntExtra("age", 0)
        val valor: TextView = findViewById(R.id.valor)
        val estado: TextView = findViewById(R.id.estado)
        val estado2: TextView = findViewById(R.id.estado2)
        calc.setOnClickListener {
            finish()
        }
        try {
            var bmi = ((weight*703) / (height*height))
            valor.text = bmi.toString()

            if (bmi <= 18.5 && bmi >= 24.9) {
                estado.text = "NORMAL"
                estado.setTextColor(Color.GREEN)
                estado2.text = "NORMAL"
            } else if (bmi < 25.0 && bmi >= 29.9) {
                estado.text = "OBESE"
                estado.setTextColor(Color.YELLOW)
                estado2.text = "OBESE"
            } else if (bmi > 30.0) {
                estado.text = "OVERWEIGHT"
                estado.setTextColor(Color.RED)
                estado2.text = "OVERWEIGHT"
            } else if (bmi < 18.5) {
                estado.text = "UNDERWEIGHT"
                estado.setTextColor(Color.BLUE)
                estado2.text = "UNDERWEIGHT"
            }
        } catch (e: Exception) {
            print("Error")
        }
    }
}