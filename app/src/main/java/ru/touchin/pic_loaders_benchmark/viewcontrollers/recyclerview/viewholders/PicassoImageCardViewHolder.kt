package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.pic_loaders_benchmark.extensions.picasso

class PicassoImageCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(uri: String) {
        picasso(itemView, uri, R.id.item_card_image_imageview)
    }

}
