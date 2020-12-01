package com.eminesa.udacityproject1.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.adapter.CustomAdapter
import com.eminesa.udacityproject1.databinding.FragmentShoeListBinding
import com.eminesa.udacityproject1.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        setRecyclerView(binding)

        openAddShoePage(binding)

        return binding.root
    }

    private fun openAddShoePage(binding: FragmentShoeListBinding) {
        binding.addShoeFlatButton.setOnClickListener {
            it?.findNavController()?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }
    }

    private fun setRecyclerView(binding: FragmentShoeListBinding) {
      val  adapter = CustomAdapter()

        binding.shoeRecyclerView.layoutManager = LinearLayoutManager(context,
            RecyclerView.VERTICAL,false)
        binding.shoeRecyclerView.adapter = adapter

        viewModel.getItems().observe(viewLifecycleOwner,
            Observer<List<Shoe>> { list ->
                binding.shoeRecyclerView.removeAllViews()
                adapter.setItems(list)
                adapter.notifyDataSetChanged()
            })

        binding.shoeRecyclerView.setHasFixedSize(true)
    }

}