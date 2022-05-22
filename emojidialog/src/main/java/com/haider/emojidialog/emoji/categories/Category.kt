package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.CategoryUnicodes

interface Category {
    val categoryName: String
    val categoryUnicode: List<CategoryUnicodes>
}
