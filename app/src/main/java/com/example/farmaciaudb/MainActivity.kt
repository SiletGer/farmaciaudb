package com.example.farmaciaudb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnMedicamentos = findViewById<Button>(R.id.btnMedicamentos)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnConsultas = findViewById<Button>(R.id.btnConsultas)

        btnMedicamentos.setOnClickListener {
            val intent = Intent(this, MedicamentosActivity::class.java)
            startActivity(intent)
        }

        btnRegistro.setOnClickListener {
            val intent = Intent(this, RegistrosActivity::class.java)
            startActivity(intent)
        }

        btnConsultas.setOnClickListener {
            val intent = Intent(this, ConsultasActivity::class.java)
            startActivity(intent)
        }
    }
}