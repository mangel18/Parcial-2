package edu.iest.parcial2_21239

import edu.iest.parcial2_21239.MainActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.recyclerview.widget.RecyclerView

class ImagenAdapter(private val listaImagen: ArrayList<Imagen>) : RecyclerView.Adapter<ImagenAdapter.ImagenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagenViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recursos, parent, false)
        return ImagenViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImagenViewHolder, position: Int) {
        val currentItem = listaImagen[position]
        holder.ivImagen.setImageResource(currentItem.imagen)
        holder.tvTexto.text = currentItem.texto
    }

    override fun getItemCount() = listaImagen.size

    class ImagenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImagen: ImageView = itemView.findViewById(R.id.ivFoto)
        val tvTexto: TextView = itemView.findViewById(R.id.tvTexto)

        init {
            // Agregar OnClickListener
            itemView.setOnClickListener {
                when (tvTexto.text.toString()) {
                    "Cerrar" -> {
                        // Cerrar la aplicación
                        finishAffinity(itemView.context as MainActivity)
                    }
                    "Perfil" -> {
                        // Abrir la actividad de datos de usuario
                        val intent = Intent(itemView.context, datos_usuario::class.java)
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }

        fun bind(item: Imagen) {
            ivImagen.setImageResource(item.imagen)
            tvTexto.text = item.texto
        }
    }

}
