package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.FoodDrinkCategoryUnicodes

data class FoodDrinkCategory(
    override val categoryName: String,
//    override val categoryDrawable: Int,
    override val categoryUnicode: List<FoodDrinkCategoryUnicodes> = enumValues<FoodDrinkCategoryUnicodes>().toList()
) : Category
