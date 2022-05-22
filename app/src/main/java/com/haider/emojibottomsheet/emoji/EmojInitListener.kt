package com.haider.emojibottomsheet.emoji

interface EmojiInitListener {
    fun onEmojisInitialized(isInitialized: Boolean, throwable: Throwable? = null)
}
