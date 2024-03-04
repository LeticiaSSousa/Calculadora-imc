package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: Any = if (result <= 18.5f) {
            "ABAIXO DO PESO"
        } else if (result > 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if (result >= 25.0f && result <= 29.9f) {
            "SOBREPESO"
        } else if (result >= 30f && result <= 39.9) {
            "OBESIDADE"
        } else {
            (result >= 40.0f)
            "OBESIDADE GRAVE"
        }

        classificacao.toString().also { tvClassificacao.text = it }


    }
}