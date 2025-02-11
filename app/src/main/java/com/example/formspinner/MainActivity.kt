package com.example.formspinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formspinner.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val spnOpt = arrayOf("")
    private var datos = mutableMapOf<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSpinner(this, binding.spinner, spnOpt, R.array.etiquetas)
    }

    fun clikAdd(view: View){
        if (view is Button){
            if (spnOpt[0] != "" && binding.etInfo.text.toString().isNotEmpty()){ //si && las dos condiciones son verdaderas el resultado es verdadero
                datos.put(spnOpt[0], binding.etInfo.text.toString())
            } else {
                msj(this, getString(R.string.noEmpty))
            }
            binding.etInfo.text.clear()
        }
    }

    fun clickSend(view: View){
        val myIntent = Intent(this, ResultActivity::class.java)
        datos.forEach { k,v ->
            myIntent.putExtra(k,v)
        }
        startActivity(myIntent)
    }
}