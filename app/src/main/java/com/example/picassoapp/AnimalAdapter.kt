package com.example.picassoapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


class AnimalAdapter(context: Context, animals: Array<String>, layout: Int) :
    RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    private val context: Context
    private val animals: Array<String>
    private val layout: Int


    init {
        this.context = context
        this.animals = animals
        this.layout = layout
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(animals[position]).fit()
            .placeholder(R.drawable.spinner)
            .into(holder.image, object : Callback {
                override fun onSuccess() {
                    TODO("Not yet implemented")
                }


                override fun onError(e: Exception?) {
                    TODO("Not yet implemented")
                }
            })
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.imageViewLayout) as ImageView
        }
    }

}
