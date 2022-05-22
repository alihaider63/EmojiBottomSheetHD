package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.SymbolsCategoryUnicodes

data class SymbolsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SymbolsCategoryUnicodes> = enumValues<SymbolsCategoryUnicodes>().toList()
) : Category
