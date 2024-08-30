
package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result= intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()



        val classificacao: String? = if (result <= 18.5f) {
            "MAGREZA"

        } else if(result > 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if(result> 25f && result<= 29.9f) {
            "SOBREPESO"
        } else if(result > 30f && result <= 39.9f) {
            "OBESO"
        } else  {
            "OBESIDADE GRAVE"
        }

        val color: Int = when (classificacao) {
            "MAGREZA" -> Color.parseColor("#FF0000") // Vermelho
            "NORMAL" -> Color.parseColor("#00FF00") // Verde
            "SOBREPESO" -> Color.parseColor("#FFFF00") // Amarelo
            "OBESO" -> Color.parseColor("#FFA500") // Laranja
            "OBESIDADE GRAVE" -> Color.parseColor("#FF0000") // Vermelho
            else -> Color.parseColor("#000000") // Preto (caso haja algum erro)
        }
        val textView: TextView = findViewById(R.id.tv_classificacao)
        textView.text = classificacao
        textView.setTextColor(color)



        println ("Ruan"+ result)

        }

    }