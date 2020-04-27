package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab5.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentStartBinding.inflate(inflater, container, false).apply {
            startButton.setOnClickListener {
                findNavController().navigate(R.id.startJudging)
            }
        }.root
    }

}
