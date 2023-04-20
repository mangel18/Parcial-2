package edu.iest.parcial2_21239

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvListado: RecyclerView
    private lateinit var listaImagen: ArrayList<Imagen>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poblarLista()
        rvListado = findViewById(R.id.rvListado)
        rvListado.layoutManager = GridLayoutManager(this, 2) // Configurar el GridLayoutManager para mostrar dos columnas
        rvListado.adapter = ImagenAdapter(listaImagen) // Configurar el Adapter con la lista de Imagen

        // Configurar la action bar para mostrar el ícono
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_wifi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_wifi)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_wifi)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflar el menú desde el archivo XML
        menuInflater.inflate(R.menu.menu_wifi, menu)

        // Ocultar el ícono de la aplicación en la action bar
        supportActionBar?.setDisplayShowHomeEnabled(false)

        // Configurar la action bar para mostrar el ícono
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_wifi)
        return true
    }

    private fun poblarLista() {
        listaImagen = ArrayList()
        val texto = arrayOf<String>("Gatos", "Perfil", "Configurar", "Cerrar")
        val imagen = arrayOf<Int>(R.drawable.cat, R.drawable.profile, R.drawable.config, R.drawable.close)

        for (i in texto.indices) {
            listaImagen.add(Imagen(texto[i], imagen[i]))
        }
    }
}
