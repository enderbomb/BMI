package com.enderbomb.activitat03

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.slider.Slider
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {

        var home = false
        var dona = false
        var weight = 0.0
        var height = 0.0
        var age = 0

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cardHome: MaterialCardView = findViewById(R.id.home)
        val cardDona: MaterialCardView = findViewById(R.id.dona)
        val addWeight: MaterialButton = findViewById(R.id.add)
        val weightValue: TextView = findViewById(R.id.weight_value)
        val ageValue: TextView = findViewById(R.id.age_value)
        val substractWeight: MaterialButton = findViewById(R.id.substract)
        val addAge: MaterialButton = findViewById(R.id.add_age)
        val substractAge: MaterialButton = findViewById(R.id.substract_age)
        val heightValue: TextView = findViewById(R.id.height_value)
        val slider: Slider = findViewById(R.id.slider)
        val calc: MaterialButton = findViewById(R.id.calc)

        cardHome.setOnClickListener {
            cardHome.setCardBackgroundColor("#C5ABFF".toColorInt())
            cardDona.setCardBackgroundColor(Color.TRANSPARENT)
            home = true
            dona = false
        }

        cardDona.setOnClickListener {
            cardDona.setCardBackgroundColor("#C5ABFF".toColorInt())
            cardHome.setCardBackgroundColor(Color.TRANSPARENT)
            home = false
            dona = true
        }

        slider.addOnChangeListener { _, value, _ ->
            val text = (value * 120).toDouble()
            heightValue.text = text.toInt().toString()
            height = text
        }

        addWeight.setOnClickListener {
            weight++
            weightValue.text = "${weight.toInt()}"
        }

        substractWeight.setOnClickListener {
            if (weight-1 >= 0) {
                weight--
            }
            weightValue.text = "$weight"
        }

        addAge.setOnClickListener {
            age++
            ageValue.text = "$age"
        }

        substractAge.setOnClickListener {
            if (age-1 >= 0) {
                age--
            }
            ageValue.text = "$age"
        }
        calc.setOnClickListener {
            val intent = Intent(this, Result::class.java)
            intent.putExtra("home", home)
            intent.putExtra("dona", dona)
            intent.putExtra("weight", weight)
            intent.putExtra("height", height)
            intent.putExtra("age", age)
            startActivity(intent)
        }

    }
}