package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.AnimalsNatureCategoryUnicodes

data class AnimalsNatureCategory(
    override val categoryName: String,
    override val categoryUnicode: List<AnimalsNatureCategoryUnicodes> = enumValues<AnimalsNatureCategoryUnicodes>().toList()
) : Category
