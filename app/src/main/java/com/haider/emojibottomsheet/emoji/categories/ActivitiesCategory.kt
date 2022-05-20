package com.haider.emojibottomsheet.emoji.categories

import com.haider.emojibottomsheet.emoji.categoryUnicodes.ActivityCategoryUnicodes

data class ActivitiesCategory(
    override val categoryName: String,
    override val categoryDrawable: Int,
    override val categoryUnicode: List<ActivityCategoryUnicodes> = enumValues<ActivityCategoryUnicodes>().toList()
) : Category
