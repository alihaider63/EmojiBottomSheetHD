package com.haider.emojidialog.emoji.categories

import com.haider.emojidialog.emoji.categoryUnicodes.ActivityCategoryUnicodes

data class ActivitiesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<ActivityCategoryUnicodes> = enumValues<ActivityCategoryUnicodes>().toList()
) : Category
