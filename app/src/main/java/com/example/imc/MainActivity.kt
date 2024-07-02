package com.example.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class MainActivity : AppCompatActivity() {

    lateinit var btnCalcular: Button
    lateinit var edit_text_peso: EditText
    lateinit var edit_text_altura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

        btnCalcular = findViewById(R.id.btn_calcular)
        edit_text_peso = findViewById(R.id.edit_peso)
        edit_text_altura = findViewById(R.id.edit_altura)

        btnCalcular.setOnClickListener {

            val peso = edit_text_peso.text.toString()
            val altura = edit_text_altura.text.toString()

            val intent = Intent(this, DetalhesActivity::class.java)

            if( peso.isNotEmpty() && altura.isNotEmpty()){


                intent.putExtra("altura",altura.toDouble())
                intent.putExtra("peso",peso.toDouble())

                }

            startActivity(intent)


        }







    }
}