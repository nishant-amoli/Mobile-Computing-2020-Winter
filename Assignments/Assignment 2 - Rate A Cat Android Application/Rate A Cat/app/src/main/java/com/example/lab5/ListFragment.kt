package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lab5.databinding.FragmentListBinding
import com.example.lab5.view.CatListView
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.user = ViewModelProvider(this).get(CatListView::class.java).also{ view ->
            view.name.observe(viewLifecycleOwner, Observer {name -> cat_name.text = name })
            }
        binding.user = ViewModelProvider(this).get(CatListView::class.java).also{ view ->
            view.cuteCount.observe(viewLifecycleOwner, Observer {countCute -> cute_score.text = countCute.toString()})
        }
        binding.user = ViewModelProvider(this).get(CatListView::class.java).also{ view ->
            view.notCuteCount.observe(viewLifecycleOwner, Observer {countNotCute -> not_cute_score.text = countNotCute.toString() })
        }
        binding.user = ViewModelProvider(this).get(CatListView::class.java).also{ view ->
            view.isListCompleted.observe(viewLifecycleOwner, Observer {final -> if(final) { findNavController().navigate(R.id.finalFragment)} })
        }

        /*TODO Attach your "viewModel" in xml to the "CatListView"*/

        /*TODO Setup data binding observers for name, cuteCount, notCuteCount and isListCompleted (see the slides for details on how to do it)*/

        binding.lifecycleOwner = this

        return binding.root
    }


}

