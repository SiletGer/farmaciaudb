package com.example.farmaciaudb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarritoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var carritoAdapter: CarrionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        recyclerView = findViewById(R.id.recyclerViewCarrito)
        recyclerView.layoutManager = LinearLayoutManager(this)

        carritoAdapter = CarrionAdapter(CarritoRepository.carritoItems)
        recyclerView.adapter = carritoAdapter
    }
    private fun calcularTotal(): Double {
        return CarritoRepository.carritoItems.sumByDouble { it.medicamento.precio!! * it.cantidad }
    }

    override fun onResume() {
        super.onResume()
        carritoAdapter.notifyDataSetChanged()
        val total = calcularTotal()
        findViewById<TextView>(R.id.textViewTotal).text = "Total: $${total}"
    }
    override fun onPause() {
        super.onPause()
        CarritoRepository.guardarCarrito()
    }
}