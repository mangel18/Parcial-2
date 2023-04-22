package edu.iest.parcial2_21239

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuWifi -> {
                val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager.activeNetworkInfo

                val isConnected = networkInfo != null && networkInfo.isConnected && networkInfo.type == ConnectivityManager.TYPE_WIFI

                val mensaje = if (isConnected) "Estás conectado a WiFi" else "No estás conectado a WiFi"
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
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
