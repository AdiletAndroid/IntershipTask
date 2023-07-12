package com.example.intershiptask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.intershiptask.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val model: Model by lazy { requireArguments().getParcelable<Model>("key") as Model }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData(model)
    }

    private fun showData(dataModel: Model) {
        with(binding) {
            nameTextView.text = dataModel.name
            yearTextView.text = dataModel.year.toString()
        }
    }
}


