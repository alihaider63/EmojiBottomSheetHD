package com.haider.emojibottomsheet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haider.emojibottomsheet.databinding.ActivityMainBinding
import com.haider.emojidialog.emoji.EmojiCompatUtils
import com.haider.emojidialog.emoji.EmojiInitListener
import com.haider.emojidialog.view.EmojiPickerDialog

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var emojiPickerDialog: EmojiPickerDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeEmojis()
    }

    private fun initializeEmojis() {
        EmojiCompatUtils.initialize(applicationContext, object :
            EmojiInitListener {

            override fun onEmojisInitialized(isInitialized: Boolean, throwable: Throwable?) {
                if (isInitialized) {
                    emojisInitializedActions()
                } else {
                    // handle error
                }
            }
        })
    }


    private fun emojisInitializedActions() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            showEmojiDialog()
        }

        EmojiPickerDialog.initializeEmojiCategories()
    }

    private val emojiListener = object : EmojiPickerDialog.EmojiClickListener {
        override fun onEmojiClicked(unicode: String) {
            binding.emojiValue.text = unicode
            emojiPickerDialog?.dismiss()
        }

    }

    @SuppressLint("ResourceType")
    private fun showEmojiDialog() {
        emojiPickerDialog = EmojiPickerDialog(
            supportFragmentManager,
            emojiListener,
            R.style.BottomSheetDialogTestTheme
        )
        emojiPickerDialog?.show()
    }
}
