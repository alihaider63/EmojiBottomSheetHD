package com.haider.emojibottomsheet.emoji.categories

import androidx.annotation.IntegerRes
import com.haider.emojibottomsheet.emoji.categoryUnicodes.CategoryUnicodes

interface Category {
    val categoryName: String
    val categoryDrawable: Int
    val categoryUnicode: List<CategoryUnicodes>
}
