package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.TravelPlacesCategoryUnicodes

data class TravelPlacesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<TravelPlacesCategoryUnicodes> = enumValues<TravelPlacesCategoryUnicodes>().toList()
) : Category
