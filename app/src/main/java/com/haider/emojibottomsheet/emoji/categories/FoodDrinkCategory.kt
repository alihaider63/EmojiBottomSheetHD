package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.FoodDrinkCategoryUnicodes

data class FoodDrinkCategory(
    override val categoryName: String,
    override val categoryDrawable: Int,
    override val categoryUnicode: List<FoodDrinkCategoryUnicodes> = enumValues<FoodDrinkCategoryUnicodes>().toList()
) : Category
