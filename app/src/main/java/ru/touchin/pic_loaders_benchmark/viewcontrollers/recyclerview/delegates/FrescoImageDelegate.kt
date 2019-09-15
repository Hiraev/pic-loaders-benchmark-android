package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates

import android.view.ViewGroup
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.adapters.ItemAdapterDelegate
import ru.touchin.roboswag.components.utils.UiUtils
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders.FrescoImageCardViewHolder

class FrescoImageDelegate : ItemAdapterDelegate<FrescoImageCardViewHolder, String>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
            FrescoImageCardViewHolder(UiUtils.inflate(R.layout.item_card_image_fresco, parent))

    override fun onBindViewHolder(
            holderImageCardViewHolder: FrescoImageCardViewHolder,
            item: String,
            adapterPosition: Int,
            collectionPosition: Int,
            payloads: MutableList<Any>
    ) = holderImageCardViewHolder.bind(item)

}
