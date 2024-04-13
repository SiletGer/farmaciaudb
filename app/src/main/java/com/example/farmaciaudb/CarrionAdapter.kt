package com.example.farmaciaudb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarrionAdapter(private val carritoItems: List<MedicamentoCarrito>) :
    RecyclerView.Adapter<CarrionAdapter.CarritoViewHolder>() {

    class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textName)
        private val priceTextView: TextView = itemView.findViewById(R.id.textPrice)


        fun bind(item: MedicamentoCarrito) {
            nameTextView.text = item.medicamento.nombre
            priceTextView.text = "${item.medicamento.precio} x ${item.cantidad}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        holder.bind(carritoItems[position])
    }

    override fun getItemCount() = carritoItems.size
}