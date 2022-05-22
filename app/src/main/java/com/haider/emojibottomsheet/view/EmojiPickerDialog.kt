package com.haider.emojibottomsheet.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.haider.emojibottomsheet.R
import com.haider.emojibottomsheet.databinding.ViewEmojiBottomSheetBinding
import com.haider.emojibottomsheet.emoji.EmojiCategoryTransformer
import com.haider.emojibottomsheet.emoji.categories.*
import com.haider.emojibottomsheet.view.recyclerview.BottomSheetPagesAdapter
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView

class EmojiPickerDialog(
    @NonNull private val frgManager: FragmentManager,
    @NonNull private val emojiListener: EmojiClickListener
): BottomSheetDialogFragment() {


    interface EmojiClickListener {
        fun onEmojiClicked(unicode: String)
    }

    private lateinit var binding: ViewEmojiBottomSheetBinding

    companion object {

        private var emojiCategoriesTransformedList: MutableList<List<EmojiItemView>> =
            emptyList<List<EmojiItemView>>().toMutableList()

        fun initializeEmojiCategories() {
            val emojiCategoriesList = initializeEmojiCategoryList()

            for (emojiCategory in emojiCategoriesList) {
                val emojisList = EmojiCategoryTransformer().transform(emojiCategory)
                emojiCategoriesTransformedList.add(emojisList)
            }
        }


        private fun initializeEmojiCategoryList(): List<Category> {
            return listOf(
                SmileysPeopleCategory("Smileys and People"),
                ActivitiesCategory("Activity"),
                AnimalsNatureCategory("Animals and Nature"),
                FoodDrinkCategory("Food and Drink"),
                ObjectsCategory("Objects"),
                SymbolsCategory("Symbols"),
                TravelPlacesCategory("Travel and Places"),
                FlagsCategory("Flags")
            )
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

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (emojiCategoriesTransformedList.isEmpty()) {
            throw ExceptionInInitializerError(
                "Categories not initialized, first call EmojiPickerDialog.initializeEmojiCategories()"
            )
        } else {
            setUpUI()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setUpUI() {

        val emojiCategoriesTitles = initializeEmojiCategoriesTitles()
        val adapter = BottomSheetPagesAdapter(this)

        for (emojisList in emojiCategoriesTransformedList) {
            val fragment =
                EmojiFragment.getNewInstance(
                    ArrayList(emojisList),
                    emojiListener
                )

            adapter.addFragment(fragment)
        }

        binding.emojiViewpager.adapter = adapter

        TabLayoutMediator(
            binding.emojiTitlesTab,
            binding.emojiViewpager
        ) { tab, position ->
            tab.icon = resources.getDrawable(
                emojiCategoriesTitles[position].second,
                requireContext().theme
            )
        }.attach()
    }

    fun show() {
        show(frgManager, EmojiPickerDialog::class.java.simpleName)
    }

    private fun initializeEmojiCategoriesTitles(): List<Pair<String, Int>> {
        return listOf(
            Pair(getString(R.string.smileysAndPeopleTitle), R.drawable.emoji_ios_category_people),
            Pair(getString(R.string.activitiesCategoryTitle), R.drawable.emoji_ios_category_activity),
            Pair(getString(R.string.animalsAndNatureTitle), R.drawable.emoji_ios_category_nature),
            Pair(getString(R.string.foodAndDrinkTitle), R.drawable.emoji_ios_category_food),
            Pair(getString(R.string.objectsTitle), R.drawable.emoji_ios_category_objects),
            Pair(getString(R.string.symbolsTitle), R.drawable.emoji_ios_category_symbols),
            Pair(getString(R.string.travelAndPlacesTitle), R.drawable.emoji_ios_category_travel),
            Pair(getString(R.string.flagsTitle), R.drawable.emoji_ios_category_flags)
        )
    }
}