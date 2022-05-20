package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.FlagsCategoryUnicodes

data class FlagsCategory(
    override val categoryName: String,
    override val categoryDrawable: Int,
    override val categoryUnicode: List<FlagsCategoryUnicodes> = enumValues<FlagsCategoryUnicodes>().toList()
) : Category
