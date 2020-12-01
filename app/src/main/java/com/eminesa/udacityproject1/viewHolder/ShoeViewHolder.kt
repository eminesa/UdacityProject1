package com.eminesa.udacityproject1.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.fragments.ShoeListFragmentDirections
import com.eminesa.udacityproject1.models.Shoe

class ShoeViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context)
        .inflate(R.layout.item_list_shoe, viewGroup, false)
) {
    private val name by lazy { itemView.findViewById<TextView>(R.id.shoeNameTextView) }
    private val company by lazy { itemView.findViewById<TextView>(R.id.shoeCompanyTextView) }
    private val size by lazy { itemView.findViewById<TextView>(R.id.shoeSizeTextView) }
    private val description by lazy { itemView.findViewById<TextView>(R.id.shoeDescriptionTextView) }

    fun bindTo(dataDTO: Shoe) {

        name.text = dataDTO.name
        company.text = dataDTO.company
        size.text = dataDTO.size.toString()
        description.text = dataDTO.description

        itemView.setOnClickListener {

            it?.findNavController()
                ?.navigate(
                    ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(
                        dataDTO.name,
                        dataDTO.size.toString(),
                        dataDTO.company,
                        dataDTO.description
                    )
                )
        }
    }
}