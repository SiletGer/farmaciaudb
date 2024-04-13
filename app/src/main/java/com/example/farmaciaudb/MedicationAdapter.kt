package com.example.farmaciaudb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MedicationAdapter(private val medications: List<Medication>) :
    RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    class MedicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(medication: Medication) {
            itemView.findViewById<TextView>(R.id.textName).text = medication.nombre
            itemView.findViewById<TextView>(R.id.textPrice).text = "${medication.precio}"
            Glide.with(itemView.context).load(medication.imagen).into(itemView.findViewById(R.id.imageMedication))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medication_item, parent, false)
        return MedicationViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        holder.bind(medications[position])
    }

    override fun getItemCount() = medications.size
}
