package com.example.formspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.formspinner.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)
        getExtras()
    }

    fun clickBack(view: View){ onBackPressed()}

    private fun getExtras(){
        val myExtras = intent.extras
        if (myExtras != null){
            val keys = myExtras.keySet()
            for (key in keys){
                b.tvDatos.text = b.tvDatos.text.toString()
                    .plus("$key:\t\t\t${myExtras.get(key)}\n")
            }
        }
    }
}