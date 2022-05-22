package com.haider.emojibottomsheet.emoji

import com.haider.emojibottomsheet.emoji.categories.Category
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView

class EmojiCategoryTransformer {

    fun transform(category: Category): List<EmojiItemView> = transformCategoryToEmojiItems(category).filter {
        EmojiCompatUtils.hasEmojiGlyph(it.unicode)
//        true
    }

    private fun transformCategoryToEmojiItems(category: Category): List<EmojiItemView> {
        val list: MutableList<EmojiItemView> = mutableListOf()

        list.apply {
            category.categoryUnicode.forEach {
                list.add(EmojiItemView.createEmojiViewItem(it.unicode, it.name))
            }
        }

        return list
    }
}
