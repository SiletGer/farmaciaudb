package com.example.farmaciaudb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

    class ConsultasActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_consultas)

            val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)

            supportActionBar?.title = "Consultas"
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {

            menuInflater.inflate(R.menu.menu_consultas, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {

            return when (item.itemId) {
                R.id.action_cart -> {

                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
    }
}