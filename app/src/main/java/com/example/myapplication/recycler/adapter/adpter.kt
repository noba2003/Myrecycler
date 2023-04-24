package com.example.myapplication.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recycler.model.massenger
import com.example.myapplication.recycler.model.onListclike

class adpter : RecyclerView.Adapter<adpter.viewHolder>() {


    var list :ArrayList<massenger> =ArrayList()
    var oncklic: onListclike? = null
    fun setlist(lists:ArrayList<massenger>){
        this.list=lists
        notifyDataSetChanged()
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
var image:ImageView=itemView.findViewById(R.id.imageView2)
var tv_user:TextView=itemView.findViewById(R.id.textView)
var tv_massge:TextView=itemView.findViewById(R.id.textView2)
        fun bind(user:massenger){
            image.setImageResource(user.id)
            tv_massge.text=user.message
            tv_user.text=user.name
            itemView.setOnClickListener {
                oncklic?.onClikLicener(user)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
      var la=LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return viewHolder(la)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var p:massenger=list.get(position)
        holder.bind(p)
    }


}