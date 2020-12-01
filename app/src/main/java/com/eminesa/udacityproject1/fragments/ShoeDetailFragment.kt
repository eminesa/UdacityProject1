package com.eminesa.udacityproject1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)

        val name = arguments?.let { ShoeDetailFragmentArgs.fromBundle(it).stringShoeName }
        val size = arguments?.let { ShoeDetailFragmentArgs.fromBundle(it).stringShoeSize }
        val desc = arguments?.let { ShoeDetailFragmentArgs.fromBundle(it).stringShoeDescription }
        val company = arguments?.let { ShoeDetailFragmentArgs.fromBundle(it).stringShoeCompany }

        binding.shoeNameDetailTextView.text = name
        binding.shoeSizeDetailTextView.text = size.toString()
        binding.shoeDescriptionDetailTextView.text = desc
        binding.shoeCompanyNameDetailTextView.text = company

        return binding.root
    }

}