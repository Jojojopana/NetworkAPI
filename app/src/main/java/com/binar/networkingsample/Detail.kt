package com.binar.networkingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.networkingsample.databinding.FragmentDetailBinding
import com.binar.networkingsample.databinding.FragmentHomeBinding


class Detail : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val navArgs: DetailArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val view = binding.root
        return (view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textharga.text = navArgs.mobil.price.toString()
        binding.textjudul.text = navArgs.mobil.name
    }
}