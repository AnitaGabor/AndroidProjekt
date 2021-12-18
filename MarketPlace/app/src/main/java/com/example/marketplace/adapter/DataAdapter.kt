package com.example.marketplace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.R
import com.example.marketplace.timeline.Product

class DataAdapter(
private var list: ArrayList<Product>,
private val listener: OnItemClickListener,
private val listener2: OnItemLongClickListener
) :
RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int)
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val productName: TextView = itemView.findViewById(R.id.productNameTextView)
        val price: TextView = itemView.findViewById(R.id.priceTextView)
        val seller: TextView = itemView.findViewById(R.id.sellerTextView)

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
            listener.onItemClick(currentPosition)

        }

        override fun onLongClick(p0: View?): Boolean {
            val currentPosition = this.adapterPosition
            listener2.onItemLongClick(currentPosition)
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.customer_layout, parent, false)
        return DataViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = list[position]
        holder.productName.text = currentItem.title
        holder.price.text = currentItem.price_per_unit
        holder.seller.text = currentItem.username
    }

    override fun getItemCount() = list.size

    fun setData(newlist: ArrayList<Product>) {
        list = newlist
    }


}