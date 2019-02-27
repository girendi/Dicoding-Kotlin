package com.d4ti.submission1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class DataAdapter(var list : MutableList<Data>, var listener : (Data) -> Unit)
    : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder{
        return DataViewHolder(DataUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindItem(list[position], listener)

    }

    inner class DataViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var imageView : ImageView = itemView.findViewById(DataUI.imageId)
        var textView : TextView = itemView.findViewById(DataUI.nameId)

        fun bindItem(data: Data, listener: (Data) -> Unit) {
            textView.text = data.name
            data.image?.let { Picasso.get().load(it).into(imageView) }
            itemView.setOnClickListener {
                listener(data)
            }
        }

    }
}