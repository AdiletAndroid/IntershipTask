package com.example.intershiptask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intershiptask.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: Adapter
    private lateinit var dataList: List<Model>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataList = mutableListOf(
            Model(R.drawable.image1, "Name 1", 2021),
            Model(R.drawable.image2, "Name 2", 2022),
            Model(R.drawable.image3, "Name 3", 2023)
        )

        adapter = Adapter { model ->
            onItemClick(model)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.showData(dataList)
    }

    private fun onItemClick(model: Model) {
        val bundle = Bundle()
        bundle.putParcelable("key", model)
        findNavController().navigate(R.id.detailsFragment, bundle)
    }
}
