package com.example.intershiptask

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Model(
    val image: Int,
    val name: String,
    val year: Int
) : Parcelable
