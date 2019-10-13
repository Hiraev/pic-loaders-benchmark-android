package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.pic_loaders_benchmark.utils.Timer

class CoilImageCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(uri: String) {
        Timer.startTimer(uri)
        itemView.findViewById<ImageView>(R.id.item_card_image_imageview).load(uri) {
            listener(onSuccess = { _, _ -> Timer.stopTimer(uri) })
            placeholder(R.drawable.placeholder_loading)
            error(R.drawable.placeholder_error)
        }
    }

}