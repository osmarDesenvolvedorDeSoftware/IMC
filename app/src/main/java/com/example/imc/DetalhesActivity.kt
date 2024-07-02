package com.example.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var textPeso: TextView
    lateinit var textAltura: TextView
    lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets  }

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras

        if(bundle != null){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso Informado: $peso KG"
            textAltura.text = "Altura Informada: $altura M"

            val imc = peso / (altura * altura)

            if(imc < 18.5){
                textResultado.text = "IMC: Baixo"
            }else if(imc in 18.5..24.9){
                textResultado.text = "IMC: Normal"
            } else if (imc in 25.0..29.9){
                textResultado.text = "IMC: Sobrepeso"
            }else{
                textResultado.text = "IMC: Obesidade"
            }

        }



    }
}