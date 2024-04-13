package com.example.farmaciaudb

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MedicamentosActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchMedications()
    }

    private fun fetchMedications() {
        val databaseReference = FirebaseDatabase.getInstance().getReference("medicamentos")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val medications = mutableListOf<Medication>()
                snapshot.children.forEach { child ->
                    child.getValue(Medication::class.java)?.let { medications.add(it) }
                }
                val adapter = MedicationAdapter(medications, this@MedicamentosActivity::onAddToCartClicked)
                recyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MedicamentosActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun onAddToCartClicked(medication: Medication) {
        CarritoRepository.agregarAlCarrito(medication, 1)
        Toast.makeText(this, "Medicamento agregado: ${medication.nombre}", Toast.LENGTH_SHORT).show()
    }
}