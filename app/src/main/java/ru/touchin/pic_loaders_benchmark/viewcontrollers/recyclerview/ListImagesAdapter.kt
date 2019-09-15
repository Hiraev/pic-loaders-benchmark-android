package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview

import androidx.recyclerview.widget.DiffUtil
import ru.touchin.adapters.DelegationListAdapter

class ListImagesAdapter : DelegationListAdapter<String>(CALLBACK) {


    companion object {

        private val CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) =
                    oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String) =
                    oldItem == newItem
        }
    }

}