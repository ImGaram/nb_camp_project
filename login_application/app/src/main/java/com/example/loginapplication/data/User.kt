package com.example.loginapplication.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String?,
    val id: String?,
    val password: String?,
): Parcelable