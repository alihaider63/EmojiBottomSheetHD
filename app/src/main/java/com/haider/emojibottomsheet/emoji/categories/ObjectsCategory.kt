package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.ObjectsCategoryUnicodes

data class ObjectsCategory(
    override val categoryName: String,
//    override val categoryDrawable: Int,
    override val categoryUnicode: List<ObjectsCategoryUnicodes> = enumValues<ObjectsCategoryUnicodes>().toList()
) : Category
