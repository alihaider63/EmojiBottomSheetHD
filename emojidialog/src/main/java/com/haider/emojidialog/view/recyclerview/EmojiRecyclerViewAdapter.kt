package com.haider.emojidialog.view.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.emoji.widget.EmojiTextView
import androidx.recyclerview.widget.RecyclerView
import com.haider.emojidialog.R

class EmojiRecyclerViewAdapter(
    //private val unicodeList: List<EmojiItemView>
    private val unicodeList: List<String>
) : RecyclerView.Adapter<EmojiRecyclerViewAdapter.EmojiListHolder>() {

    class EmojiListHolder(inflatedView: View) : RecyclerView.ViewHolder(inflatedView) {
        val emojiTextView: EmojiTextView? by bind(R.id.etv_emoji )
        //val emojiTextView: AppCompatTextView? by bind(R.id.etv_emoji )

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiListHolder {
        return EmojiListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_emoji, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmojiListHolder, position: Int) {

        createEmojiItem(holder, position)
    }

    private fun createEmojiItem(holder: EmojiListHolder, position: Int) {
        holder.emojiTextView?.let { item ->
            item.apply {
                text = getEmojiItem(position)//.unicode
                setOnClickListener {
                    emojiClickedListener(getEmojiItem(position), it)
                }
            }
        }
    }

    private fun getEmojiItem(position: Int) = unicodeList[position]

    override fun getItemCount(): Int = unicodeList.size

    internal var emojiClickedListener: (String, View) -> Unit = { _, _ -> }

}
