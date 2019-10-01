package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.viewholders

import android.graphics.drawable.Animatable
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.extensions.findViewById
import ru.touchin.pic_loaders_benchmark.utils.Timer

class FrescoImageCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(uri: String) {
        Timer.startTimer(uri)
        Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(uri))
                .setControllerListener(onLoadListener(uri))
                .build()
                .let {
                    findViewById<SimpleDraweeView>(R.id.item_card_image_imageview).controller = it
                }
    }

    private fun onLoadListener(uri: String) = object : BaseControllerListener<ImageInfo>() {
        override fun onFinalImageSet(id: String, imageInfo: ImageInfo?, animatable: Animatable?) {
            super.onFinalImageSet(id, imageInfo, animatable)
            Timer.stopTimer(uri)
        }
    }

}
