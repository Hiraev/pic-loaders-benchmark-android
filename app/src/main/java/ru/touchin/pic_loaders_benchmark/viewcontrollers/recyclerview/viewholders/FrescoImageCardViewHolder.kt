package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.touchin.pic_loaders_benchmark.R

import ru.touchin.extensions.findViewById

class FrescoImageCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(uri: String) {
        findViewById<SimpleDraweeView>(R.id.item_card_image_imageview).setImageURI(uri)
    }

}
