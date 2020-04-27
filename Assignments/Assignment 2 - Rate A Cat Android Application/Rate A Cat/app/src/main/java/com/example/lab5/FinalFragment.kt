package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lab5.databinding.FragmentFinalBinding

private const val IMG_URL = "https://images.unsplash.com/photo-1531425300797-d5dc8b021c84?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"

class FinalFragment : Fragment() {

    private lateinit var binding: FragmentFinalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalBinding.inflate(inflater, container, false)
        Glide.with(this).load(IMG_URL).into(binding.finalImage)
        return binding.root
    }

}
