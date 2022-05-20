package com.haider.emojibottomsheet.view

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

    private lateinit var binding: ViewEmojiBottomSheetBinding

    companion object {
        const val EMOJI_CATEGORIES_LIST = "EMOJI_CATEGORIES_LIST"
        fun getNewInstance(whoReactedList: ArrayList<EmojiItemView>) = EmojiBottomSheet().apply {
            val bundle = Bundle()
            bundle.putParcelableArrayList(EMOJI_CATEGORIES_LIST, whoReactedList)
            arguments = bundle
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
//
//    override fun getTheme(): Int {
//        return R.style.AppBottomSheetDialogTheme
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val emojiCategoriesList = arguments?.getParcelableArrayList<Category>(EMOJI_CATEGORIES_LIST)

        val emojiCategoriesList = initializeEmojiCategoryList()

        val adapter = BottomSheetPagesAdapter(this)

        if (emojiCategoriesList != null) {
            for (emojiCategory in emojiCategoriesList) {
                val emojiCategoriesList = EmojiCategoryTransformer().transform(emojiCategory)
                val fragment = EmojiFragment.getNewInstance(ArrayList(emojiCategoriesList))
                adapter.addFragment(fragment, "")
            }
        }

        binding.emojiViewpager.adapter = adapter

        //binding.whoReactedTab.setupWithViewPager(binding.whoReactedViewpager)
        TabLayoutMediator(binding.emojiTitlesTab, binding.emojiViewpager) { tab, position ->
            tab.text = emojiCategoriesList?.get(position)?.categoryName
        }.attach()

    }

    private fun initializeEmojiCategoryList(): List<Category> {
        return listOf(
            SmileysPeopleCategory(getString(R.string.smileysAndPeopleTitle)),
            ActivitiesCategory(getString(R.string.activitiesCategoryTitle)),
            AnimalsNatureCategory(getString(R.string.animalsAndNatureTitle)),
            FoodDrinkCategory(getString(R.string.foodAndDrinkTitle)),
            ObjectsCategory(getString(R.string.objectsTitle)),
            SymbolsCategory(getString(R.string.symbolsTitle)),
            TravelPlacesCategory(getString(R.string.travelAndPlacesTitle)),
            FlagsCategory(getString(R.string.flagsTitle))
        )
    }
}