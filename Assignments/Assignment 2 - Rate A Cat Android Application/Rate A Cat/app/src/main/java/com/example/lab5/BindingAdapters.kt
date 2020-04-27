package com.example.lab5

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

// Wire Glide up to fetch and display the image at a URL obtained through data binding.
/*TODO implement the binding Adapter*/
@BindingAdapter("app:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView);}