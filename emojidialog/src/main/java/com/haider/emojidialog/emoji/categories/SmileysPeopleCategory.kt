package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.SmileysPeopleCategoryUnicodes

data class SmileysPeopleCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SmileysPeopleCategoryUnicodes> = enumValues<SmileysPeopleCategoryUnicodes>().toList()
) : Category