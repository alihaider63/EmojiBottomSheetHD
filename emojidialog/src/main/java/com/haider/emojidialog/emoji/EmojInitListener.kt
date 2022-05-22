package com.haider.emojidialog.emoji

interface EmojiInitListener {
    fun onEmojisInitialized(isInitialized: Boolean, throwable: Throwable? = null)
}
