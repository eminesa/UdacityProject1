package com.eminesa.udacityproject1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.databinding.ItemListShoeBinding
import com.eminesa.udacityproject1.models.Shoe
import com.eminesa.udacityproject1.viewHolder.ShoeViewHolder

class CustomAdapter() : RecyclerView.Adapter<ShoeViewHolder>() {

    private lateinit var customBinder : ItemListShoeBinding

    private var list : MutableList<Shoe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        customBinder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_shoe,
            parent,
            false
        )
        return ShoeViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        customBinder.model = list[position]
        holder.bindTo(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItems(items : List<Shoe>) {
        list.clear()
        list.addAll(items)
        notifyItemRangeChanged(0, itemCount)
    }
}


