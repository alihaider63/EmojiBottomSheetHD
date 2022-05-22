package com.haider.emojibottomsheet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haider.emojibottomsheet.databinding.FragmentEmojiBinding
import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView
import com.haider.emojibottomsheet.view.recyclerview.EmojiRecyclerViewAdapter

class EmojiFragment : Fragment() {

    private lateinit var binding: FragmentEmojiBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var listener: EmojiPickerDialog.EmojiClickListener

    companion object {
        private const val EMOJI_LIST = "EMOJI_LIST"
        fun getNewInstance(
            userList: ArrayList<EmojiItemView>,
            emojiListener: EmojiPickerDialog.EmojiClickListener
        ) = EmojiFragment().apply {
            listener = emojiListener
            val bundle = Bundle()
            bundle.putParcelableArrayList(EMOJI_LIST, userList)
            arguments = bundle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEmojiBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emojiItemViewList = arguments?.getParcelableArrayList<EmojiItemView>(EMOJI_LIST)

        val context = context
        if (emojiItemViewList != null && context != null) {
            //adapter = EmojiSheetTitlesAdapter(userList)
            attachLayoutManager()
            binding.recyclerViewEmojis.adapter = EmojiRecyclerViewAdapter(emojiItemViewList).apply {
                emojiClickedListener = { item, _ ->
                    selectEmoji(item)
                }

            }
        }

    }

    private fun selectEmoji(itemView: EmojiItemView) {
        listener.onEmojiClicked(itemView.unicode)
    }

    private fun attachLayoutManager() {
        gridLayoutManager = GridLayoutManager(context, 8)
        gridLayoutManager.apply {
            binding.recyclerViewEmojis.layoutManager = this
            isSmoothScrollbarEnabled = true
            orientation = RecyclerView.VERTICAL
        }
    }
}