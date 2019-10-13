package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates

import android.view.ViewGroup
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.adapters.ItemAdapterDelegate
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders.CoilImageCardViewHolder
import ru.touchin.roboswag.components.utils.UiUtils

class CoilImagesDelegate : ItemAdapterDelegate<CoilImageCardViewHolder, String>() {

    override fun onCreateViewHolder(parent: ViewGroup) =
            CoilImageCardViewHolder(UiUtils.inflate(R.layout.item_card_image, parent))

    override fun onBindViewHolder(
            holder: CoilImageCardViewHolder,
            item: String,
            adapterPosition: Int,
            collectionPosition: Int,
            payloads: MutableList<Any>
    ) = holder.bind(item)

}
