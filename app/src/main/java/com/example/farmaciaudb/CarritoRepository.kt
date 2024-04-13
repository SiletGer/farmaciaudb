package com.example.farmaciaudb

import android.util.Log

object CarritoRepository {
    val carritoItems = mutableListOf<MedicamentoCarrito>()

    fun agregarAlCarrito(medicamento: Medication, cantidad: Int) {
        val itemExistente = carritoItems.find { it.medicamento.nombre == medicamento.nombre }
        if (itemExistente != null) {
            itemExistente.cantidad += cantidad
        } else {
            carritoItems.add(MedicamentoCarrito(medicamento, cantidad))
        }
        Log.d("CarritoRepository", "Item agregado. Tamaño del carrito: ${carritoItems.size}")
    }

    fun guardarCarrito() {
        TODO("Not yet implemented")
    }
}