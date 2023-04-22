package edu.iest.parcial2_21239

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class datos_usuario : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etDuenho: EditText
    private lateinit var etGato: EditText
    private lateinit var etEdad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_usuario)

        sharedPreferences = getSharedPreferences("MiPreferencia", MODE_PRIVATE)
        etDuenho = findViewById(R.id.etDuenho)
        etGato = findViewById(R.id.etGato)
        etEdad = findViewById(R.id.etEdad)

        val nombreDuenho = sharedPreferences.getString("nombreDuenho", "")
        val nombreGato = sharedPreferences.getString("nombreGato", "")
        val edadGato = sharedPreferences.getString("edadGato", "")

        etDuenho.setText(nombreDuenho)
        etGato.setText(nombreGato)
        etEdad.setText(edadGato)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val nombreDuenho = etDuenho.text.toString()
            val nombreGato = etGato.text.toString()
            val edadGato = etEdad.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("nombreDuenho", nombreDuenho)
            editor.putString("nombreGato", nombreGato)
            editor.putString("edadGato", edadGato)
            editor.apply()

            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
        }
    }
}
