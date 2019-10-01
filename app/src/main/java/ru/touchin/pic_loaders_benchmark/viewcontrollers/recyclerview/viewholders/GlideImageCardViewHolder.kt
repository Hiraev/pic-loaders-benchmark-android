package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.pic_loaders_benchmark.extensions.glide
import ru.touchin.pic_loaders_benchmark.utils.Timer

class GlideImageCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(uri: String) {
        Timer.startTimer(uri)
        glide(itemView, uri, R.id.item_card_image_imageview) {
            Timer.stopTimer(uri)
        }
    }

}
