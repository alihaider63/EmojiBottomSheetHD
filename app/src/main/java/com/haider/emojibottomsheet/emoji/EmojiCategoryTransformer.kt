package com.haider.emojibottomsheet.emoji

import com.haider.emojibottomsheet.emoji.categories.Category
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemType
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView

class EmojiCategoryTransformer {

    fun transform(categoryList: List<Category>): List<EmojiItemView> = transformCategoriesToEmojiItems(categoryList)

    private fun transformCategoriesToEmojiItems(createEmojiList: List<Category>): List<EmojiItemView> {
        val list: MutableList<EmojiItemView> = mutableListOf()
        createEmojiList.map { category ->
            //list.add(EmojiItemView.createTitleViewItem(category.categoryName))
            list.apply {
                category.categoryUnicode.forEach {
                    list.add(EmojiItemView.createEmojiViewItem(it.unicode, it.name))
                }
            }
        }
        return list
    }


    fun transform(category: Category): List<EmojiItemView> = transformCategoryToEmojiItems(category).filter {
        EmojiCompatUtils.hasEmojiGlyph(it.value)
    }

    private fun transformCategoryToEmojiItems(category: Category): List<EmojiItemView> {
        val list: MutableList<EmojiItemView> = mutableListOf()

        //list.add(EmojiItemView.createTitleViewItem(category.categoryName))
        list.apply {
            category.categoryUnicode.forEach {
                list.add(EmojiItemView.createEmojiViewItem(it.unicode, it.name))
            }
        }

        return list
    }
}
