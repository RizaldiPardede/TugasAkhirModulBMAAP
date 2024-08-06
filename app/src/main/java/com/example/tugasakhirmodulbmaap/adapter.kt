package com.example.tugasakhirmodulbmaap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class adapter(val listartikel: ArrayList<artikel>):RecyclerView.Adapter<adapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView= itemView.findViewById(R.id.img_item_photo)
        val name: TextView = itemView.findViewById(R.id.tv_item_name)
        val desc: TextView = itemView.findViewById(R.id.tv_item_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.row_rvlist,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(nama,desc,photo,tanggalRilis,isi)= listartikel[position]
        holder.img.setImageResource(photo)
        holder.name.text=nama
        holder.desc.text= desc
//        holder.itemView.setOnClickListener{
//            val moveWithDataIntent = Intent(this@adapter, detail::class.java)
//            moveWithDataIntent.putExtra(detail.EXTRA_judul, listartikel[holder.adapterPosition].nama)
//            moveWithDataIntent.putExtra(detail.EXTRA_photo, listartikel[holder.adapterPosition].photo)
//            moveWithDataIntent.putExtra(detail.EXTRA_isi, listartikel[holder.adapterPosition].isi)
//            moveWithDataIntent.putExtra(detail.EXTRA_tanggal, listartikel[holder.adapterPosition].tanggalRilis)
//            startActivity(moveWithDataIntent)

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listartikel[holder.adapterPosition])}

    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: artikel)
    }
    override fun getItemCount(): Int=listartikel.size

}