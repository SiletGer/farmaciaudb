package com.example.farmaciaudb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.farmaciaudb.R
class MedicamentoAdapter(private val medicamentos: List<Medicamento>) : RecyclerView.Adapter<MedicamentoAdapter.MedicamentoViewHolder>() {
    class MedicamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewMedicamento)
        val nombreView: TextView = itemView.findViewById(R.id.textViewNombreMedicamento)
        val precioView: TextView = itemView.findViewById(R.id.textViewPrecioMedicamento)
        val addButton: Button = itemView.findViewById(R.id.buttonAgregar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        val medicamento = medicamentos[position]
        holder.nombreView.text = medicamento.nombre
        holder.precioView.text = String.format("$%.2f", medicamento.precio)
        Glide.with(holder.imageView.context).load(medicamento.fotoUrl).into(holder.imageView)

        // aqui se configura el boton de agregar
        holder.addButton.setOnClickListener {
        }
    }
    override fun getItemCount() = medicamentos.size
}