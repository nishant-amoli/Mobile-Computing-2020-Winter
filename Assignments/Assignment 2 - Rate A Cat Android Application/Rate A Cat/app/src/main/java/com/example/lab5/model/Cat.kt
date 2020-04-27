package com.example.lab5.model

import com.google.gson.annotations.SerializedName

data class Cat(

    @SerializedName("image_url")
    var imageUrl: String,
    var name: String,
    var id: String
)
