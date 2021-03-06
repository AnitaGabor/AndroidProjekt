package com.example.marketplace.timeline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.R
import com.example.marketplace.timeline.model.Product
import java.util.*
import kotlin.collections.ArrayList

class TimeLineDataAdapter(
    private var list: ArrayList<Product>,
    private val listener: OnItemClickListener
) :
RecyclerView.Adapter<TimeLineDataAdapter.DataViewHolder>() {
    private val arrayList : ArrayList<Product> = ArrayList()

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val productName: TextView = itemView.findViewById(R.id.productNameTextViewSales)
        val price: TextView = itemView.findViewById(R.id.TextView)
        val seller: TextView = itemView.findViewById(R.id.sellerTextViewSales)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
            listener.onItemClick(currentPosition)

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