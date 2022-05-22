package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.SymbolsCategoryUnicodes

data class SymbolsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SymbolsCategoryUnicodes> = enumValues<SymbolsCategoryUnicodes>().toList()
) : Category
