package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.CategoryUnicodes

interface Category {
    val categoryName: String
    val categoryUnicode: List<CategoryUnicodes>
}
