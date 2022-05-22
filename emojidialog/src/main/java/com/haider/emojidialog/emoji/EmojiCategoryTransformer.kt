package com.haider.emojidialog.emoji

import com.haider.emojidialog.emoji.categories.Category
import com.haider.emojidialog.view.recyclerview.EmojiItemView

class EmojiCategoryTransformer {

    fun transform(category: Category): List<com.haider.emojidialog.view.recyclerview.EmojiItemView> = transformCategoryToEmojiItems(category).filter {
        com.haider.emojidialog.emoji.EmojiCompatUtils.hasEmojiGlyph(it.unicode)
//        true
    }

    private fun transformCategoryToEmojiItems(category: Category): List<com.haider.emojidialog.view.recyclerview.EmojiItemView> {
        val list: MutableList<com.haider.emojidialog.view.recyclerview.EmojiItemView> = mutableListOf()

        list.apply {
            category.categoryUnicode.forEach {
                list.add(com.haider.emojidialog.view.recyclerview.EmojiItemView.createEmojiViewItem(it.unicode, it.name))
            }
        }

        return list
    }
}
