package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.AnimalsNatureCategoryUnicodes

data class AnimalsNatureCategory(
    override val categoryName: String,
    override val categoryUnicode: List<AnimalsNatureCategoryUnicodes> = enumValues<AnimalsNatureCategoryUnicodes>().toList()
) : Category
