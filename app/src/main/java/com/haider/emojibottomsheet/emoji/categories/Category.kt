package com.haider.emojibottomsheet.emoji.categories

import android.os.Parcelable
import com.haider.emojibottomsheet.emoji.categoryUnicodes.CategoryUnicodes
import kotlinx.parcelize.Parcelize

@Parcelize
class Category (
    val categoryName: String,
    val categoryUnicode: List<CategoryUnicodes>
) : Parcelable
