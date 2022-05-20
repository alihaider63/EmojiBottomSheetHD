package com.haider.emojibottomsheet.emoji.categoryUnicodes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CategoryUnicodes (
    val name: String,
    val unicode: ByteArray
) : Parcelable
