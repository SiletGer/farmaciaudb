package com.example.farmaciaudb

class Medicamento(
    val nombre: String,
    val precio: Double,
    val fotoUrl: String,
    val descripcion: String? = null
) {
    constructor() : this("", 0.0, "")
}