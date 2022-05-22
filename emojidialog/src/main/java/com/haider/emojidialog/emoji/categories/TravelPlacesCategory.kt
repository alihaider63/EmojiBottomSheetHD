package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.TravelPlacesCategoryUnicodes

data class TravelPlacesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<TravelPlacesCategoryUnicodes> = enumValues<TravelPlacesCategoryUnicodes>().toList()
) : Category
