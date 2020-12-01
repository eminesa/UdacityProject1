package com.eminesa.udacityproject1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.eminesa.udacityproject1.MainActivity
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentAddShoeBinding>(inflater, R.layout.fragment_add_shoe, container, false)

        val activity: MainActivity? = activity as MainActivity?
        binding.cancelShoeButton.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }

}