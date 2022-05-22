package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.FlagsCategoryUnicodes

data class FlagsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<FlagsCategoryUnicodes> = enumValues<FlagsCategoryUnicodes>().toList()
) : Category
