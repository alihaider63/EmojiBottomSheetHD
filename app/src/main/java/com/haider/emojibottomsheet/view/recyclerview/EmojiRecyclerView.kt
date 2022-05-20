package com.haider.emojibottomsheet.view.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.nio.charset.StandardCharsets

@Parcelize
data class EmojiItemView(val value: String, val type: EmojiItemType = EmojiItemType.EMOJI, val name: String? = null): Parcelable {
    companion object {
        fun createEmojiViewItem(unicode: ByteArray, unicodeName: String): EmojiItemView {
            return EmojiItemView(unicode.toAscii(), EmojiItemType.EMOJI, unicodeName)
        }

        fun createTitleViewItem(categoryName: String): EmojiItemView {
            return EmojiItemView(categoryName, EmojiItemType.TITLE)
        }
    }
}

enum class EmojiItemType {
    TITLE,
    EMOJI
}

fun ByteArray.toAscii(): String {
    return String(this, StandardCharsets.UTF_8)
}
