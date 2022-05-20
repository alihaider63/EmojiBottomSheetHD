package com.haider.emojibottomsheet

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.emoji.widget.EmojiTextView
import com.haider.emojibottomsheet.databinding.ActivityMainBinding
import com.haider.emojibottomsheet.emoji.EmojInitListener
import com.haider.emojibottomsheet.emoji.EmojiCategoryTransformer
import com.haider.emojibottomsheet.emoji.EmojiCompatUtils
import com.haider.emojibottomsheet.emoji.categories.*
import com.haider.emojibottomsheet.view.EmojiClickListener
import com.haider.emojibottomsheet.view.EmojiPickerDialog
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView

class MainActivity : AppCompatActivity() {

    private var emojiItemViewList: List<EmojiItemView> = emptyList()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeEmojiCategoriesPreferred()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            showEmojiDialog()
        }
    }

    private fun initializeEmojiCategoriesPreferred() {
        emojiItemViewList = EmojiCategoryTransformer().transform(initializeEmojiCategoryList())
    }

    private fun showEmojiDialog() {
        EmojiPickerDialog.Builder(this@MainActivity, emojiItemViewList)
            .dismissWithAnimation(true)
            .title(getString(R.string.emojiDialogTitle))
            .cancelable(true)
            .listener(object : EmojiClickListener {
                override fun emojiClicked(unicode: EmojiItemView) {
                    binding.tvSelectedEmojiName.text = unicode.value
                }
            }).build().show()
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
