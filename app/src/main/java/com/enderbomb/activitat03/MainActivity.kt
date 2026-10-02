package com.enderbomb.activitat03

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
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

    override fun onCreate(savedInstanceState: Bundle?) {

        var home = false
        var dona = false
        var weight: Int = 0;
        var age: Int = 0;

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

        slider.addOnChangeListener { slider, value, fromUser ->
            var text = (value * 120).toInt()
            heightValue.text = "$text"
        }

        addWeight.setOnClickListener {
            weight++
            weightValue.text = "$weight"
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
    }
}