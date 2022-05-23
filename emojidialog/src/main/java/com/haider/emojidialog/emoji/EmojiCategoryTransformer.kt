package com.haider.emojidialog.emoji

import com.haider.emojidialog.emoji.categories.Category
import com.haider.emojidialog.view.recyclerview.EmojiItemView

class EmojiCategoryTransformer {

    fun transform(category: Category): List<EmojiItemView> = transformCategoryToEmojiItems(category).filter {
//        EmojiCompatUtils.hasEmojiGlyph(it.unicode)
        true
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
