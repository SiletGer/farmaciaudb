package com.example.farmaciaudb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MedicationAdapter(private val medications: List<Medication>, private val onAddToCartClicked: (Medication) -> Unit) :
    RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    class MedicationViewHolder(itemView: View, private val onAddClick: (Medication) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageMedication)
        private val nameTextView: TextView = itemView.findViewById(R.id.textName)
        private val priceTextView: TextView = itemView.findViewById(R.id.textPrice)
        private val addButton: TextView = itemView.findViewById(R.id.buttonAdd)

        fun bind(medication: Medication) {
            nameTextView.text = medication.nombre ?: "Nombre no disponible"
            priceTextView.text = "${medication.precio}"
            medication.imagen?.let { imageUrl ->
                Glide.with(itemView.context).load(imageUrl).into(imageView)
            } ?: imageView.setImageResource(R.drawable.default_image)
            addButton.setOnClickListener { onAddClick(medication) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medication_item, parent, false)
        return MedicationViewHolder(view, onAddToCartClicked)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        holder.bind(medications[position])
    }

    override fun getItemCount() = medications.size
}