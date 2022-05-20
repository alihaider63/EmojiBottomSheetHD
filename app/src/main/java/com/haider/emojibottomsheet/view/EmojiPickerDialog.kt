//package com.haider.emojibottomsheet.view
//
//import android.content.Context
//import android.view.View
//import android.widget.LinearLayout
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.bottomsheet.BottomSheetBehavior
//import com.google.android.material.bottomsheet.BottomSheetDialog
//import com.google.android.material.tabs.TabLayoutMediator
//import com.haider.emojibottomsheet.R
//import com.haider.emojibottomsheet.view.recyclerview.EmojiItemView
//import com.haider.emojibottomsheet.view.recyclerview.BottomSheetPagesAdapter
//
//class EmojiPickerDialog(
//    private val context: Context,
//    private val title: String?,
//    private val dismissWithAnim: Boolean,
//    private val cancelable: Boolean,
//    private val listener: EmojiClickListener? = null,
//    private val emojiItemViewList: List<EmojiItemView>
//) {
//    private val bottomSheetDialog = BottomSheetDialog(context)
//
//    //private lateinit var titleTextView: TextView
//    private lateinit var emojiCategoryViewContainer: LinearLayout
//
//    init {
//        createBottomSheetDialog()
//    }
//
//    private fun createBottomSheetDialog() {
//        bottomSheetDialog.apply {
//            layoutInflater.inflate(R.layout.view_emoji_bottom_sheet, null).apply {
//                setContentView(this)
//                initializeViews(this)
//            }
//            //title?.let { titleTextView.text = it }
//            dismissWithAnimation = dismissWithAnim
//            setCanceledOnTouchOutside(cancelable)
//        }
//    }
//
//    private fun initializeViews(view: View) {
//        //emojiCategoryViewContainer = view.findViewById(R.id.ll_emoji_category_view_container)
//        //titleTextView = view.findViewById(R.id.tv_bottom_sheet_title)
//        emojiListRecyclerView = view.findViewById(R.id.)
////        attachLayoutManager()
////        emojiListRecyclerView.adapter = EmojiRecyclerViewAdapter(emojiItemViewList).apply {
////            emojiClickedListener = { unicode, view ->
////                selectEmoji(unicode)
////            }
////        }
//
//        val adapter = BottomSheetPagesAdapter(this)
//
//        if (whoReactedList != null) {
//            for (whoReacted in whoReactedList) {
//                val fragment = DynamicUserReactedFragment.getNewInstance(whoReacted.userList)
//                adapter.addFragment(fragment, whoReacted.reactionTabTitle)
//            }
//        }
//
//        val sheetBehavior = BottomSheetBehavior.from(view.parent as View)
//
//        binding.whoReactedViewpager.adapter = adapter
//
//        binding.whoReactedViewpager.children.find { it is RecyclerView }?.let {
//            (it as RecyclerView).isNestedScrollingEnabled = false
//            (it as RecyclerView).overScrollMode = View.OVER_SCROLL_NEVER
//        }
//        //binding.whoReactedTab.setupWithViewPager(binding.whoReactedViewpager)
//        TabLayoutMediator(binding.whoReactedTab, binding.whoReactedViewpager) { tab, position ->
//            tab.text = whoReactedList?.get(position)?.reactionTabTitle//"OBJECT ${(position + 1)}"
//        }.attach()
//
//    }
//
//
//    fun show() {
//        bottomSheetDialog.show()
//    }
//
//
//    class Builder(
//        private val context: Context,
//        private val emojiItemViewList: List<EmojiItemView>,
//        var title: String? = null,
//        var dismissWithAnimation: Boolean = true,
//        var cancelable: Boolean = true,
//        var listener: EmojiClickListener? = null
//    ) {
//
//        fun title(text: String) = this.apply {
//            title = text
//        }
//
//        fun dismissWithAnimation(dismiss: Boolean) = this.apply {
//            dismissWithAnimation = dismiss
//        }
//
//        fun cancelable(boolean: Boolean) = this.apply {
//            cancelable = boolean
//        }
//
//        fun listener(emojiClickListener: EmojiClickListener) = this.apply {
//            listener = emojiClickListener
//        }
//
//        fun build() = EmojiPickerDialog(
//            context,
//            title,
//            dismissWithAnimation,
//            cancelable,
//            listener,
//            emojiItemViewList
//        )
//    }
//}
//
//interface EmojiClickListener {
//    fun emojiClicked(unicode: EmojiItemView)
//}
