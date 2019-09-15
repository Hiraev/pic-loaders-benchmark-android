package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates

import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.adapters.ItemAdapterDelegate
import ru.touchin.roboswag.components.utils.UiUtils
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders.PicassoImageCardViewHolder

class PicassoImagesDelegate : ItemAdapterDelegate<PicassoImageCardViewHolder, String>() {

    init {
        Picasso.get().setIndicatorsEnabled(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup) =
            PicassoImageCardViewHolder(UiUtils.inflate(R.layout.item_card_image, parent))

    override fun onBindViewHolder(
            holderImageCardViewHolder: PicassoImageCardViewHolder,
            item: String,
            adapterPosition: Int,
            collectionPosition: Int,
            payloads: MutableList<Any>
    ) = holderImageCardViewHolder.bind(item)

}