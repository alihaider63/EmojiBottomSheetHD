package com.haider.emojibottomsheet.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.haider.emojibottomsheet.R
import com.haider.emojibottomsheet.databinding.ViewEmojiBottomSheetBinding
import com.haider.emojibottomsheet.emoji.EmojiCategoryTransformer
import com.haider.emojibottomsheet.emoji.categories.*
import com.haider.emojibottomsheet.view.recyclerview.BottomSheetPagesAdapter
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView

class EmojiBottomSheet: BottomSheetDialogFragment() {


    interface EmojiClickListener {
        fun onEmojiClicked(unicode: String)
    }

    private lateinit var binding: ViewEmojiBottomSheetBinding
    private var emojiListener: EmojiClickListener? = null

    companion object {
        const val EMOJI_CATEGORIES_LIST = "EMOJI_CATEGORIES_LIST"
        fun getNewInstance(emojiClickListener: EmojiClickListener) = EmojiBottomSheet().apply {
            emojiListener = emojiClickListener
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewEmojiBottomSheetBinding.inflate(inflater)
        return binding.root
    }

//    override fun getTheme(): Int {
//        return R.style.BottomSheetDialogTheme
//    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emojiCategoriesList = initializeEmojiCategoryList()

        val adapter = BottomSheetPagesAdapter(this)

        for (emojiCategory in emojiCategoriesList) {
            val emojiCategoriesList = EmojiCategoryTransformer().transform(emojiCategory)
            val fragment = EmojiFragment.getNewInstance(ArrayList(emojiCategoriesList))
            adapter.addFragment(fragment, "")
        }

        binding.emojiViewpager.adapter = adapter

        //binding.whoReactedTab.setupWithViewPager(binding.whoReactedViewpager)
        TabLayoutMediator(binding.emojiTitlesTab, binding.emojiViewpager) { tab, position ->

            //tab.text = emojiCategoriesList?.get(position)?.categoryName
            tab.icon = resources.getDrawable(
                emojiCategoriesList[position].categoryDrawable,
                requireContext().theme
            )
        }.attach()

    }

    private fun initializeEmojiCategoryList(): List<Category> {
        return listOf(
            SmileysPeopleCategory(getString(R.string.smileysAndPeopleTitle), R.drawable.emoji_ios_category_people),
            ActivitiesCategory(getString(R.string.activitiesCategoryTitle), R.drawable.emoji_ios_category_activity),
            AnimalsNatureCategory(getString(R.string.animalsAndNatureTitle), R.drawable.emoji_ios_category_nature),
            FoodDrinkCategory(getString(R.string.foodAndDrinkTitle), R.drawable.emoji_ios_category_food),
            ObjectsCategory(getString(R.string.objectsTitle), R.drawable.emoji_ios_category_objects),
            SymbolsCategory(getString(R.string.symbolsTitle), R.drawable.emoji_ios_category_symbols),
            TravelPlacesCategory(getString(R.string.travelAndPlacesTitle), R.drawable.emoji_ios_category_travel),
            FlagsCategory(getString(R.string.flagsTitle), R.drawable.emoji_ios_category_flags)
        )
    }
}