package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.SmileysPeopleCategoryUnicodes

data class SmileysPeopleCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SmileysPeopleCategoryUnicodes> = enumValues<SmileysPeopleCategoryUnicodes>().toList()
) : Category(categoryName, categoryUnicode)
