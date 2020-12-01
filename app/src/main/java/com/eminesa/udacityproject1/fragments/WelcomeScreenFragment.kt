package com.eminesa.udacityproject1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWelcomeScreenBinding>(
            inflater, R.layout.fragment_welcome_screen, container, false
        )
        binding.showListButton.setOnClickListener {
            view?.findNavController()?.navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToShoeListFragment())
        }
        return binding.root
    }

}