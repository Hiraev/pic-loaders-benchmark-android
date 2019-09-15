package ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images

import android.graphics.drawable.Animatable
import android.net.Uri
import android.widget.TextView
import androidx.annotation.IdRes
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.pic_loaders_benchmark.ImagePaths
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.EmptyState

class FrescoImagesViewController(
        creationContext: CreationContext
) : TimerViewController<NavigationActivity, EmptyState>(
        creationContext,
        R.layout.view_controller_with_image_fresco
) {

    override val textView = findViewById<TextView>(R.id.view_controller_with_image_timer)

    override val numOfPictures: Int
        get() = 8

    private val onLoadListner = object : BaseControllerListener<ImageInfo>() {
        override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
            super.onFinalImageSet(id, imageInfo, animatable)
            onResourceLoaded()
        }
    }

    init {
        frescoIt(R.id.view_controller_with_image_logo, ImagePaths.png_small[0])
        frescoIt(R.id.view_controller_with_image_png, ImagePaths.png_small[2])
        frescoIt(R.id.view_controller_with_image_jpeg, ImagePaths.jpg_small[0])
        frescoIt(R.id.view_controller_with_image_webp_left, ImagePaths.webp_small[0])
        frescoIt(R.id.view_controller_with_image_webp_right, ImagePaths.webp_small[1])
        frescoIt(R.id.view_controller_with_image_very_big_jpeg_1, ImagePaths.jpg_small[1])
        frescoIt(R.id.view_controller_with_image_very_big_jpeg_2, ImagePaths.jpg_large[0])
        frescoIt(R.id.view_controller_with_image_very_big_jpeg_3, ImagePaths.jpg_large[2])
    }

    private fun frescoIt(@IdRes id: Int, path: String) {
        Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(path))
                .setControllerListener(onLoadListner)
                .build()
                .let {
                    findViewById<SimpleDraweeView>(id).controller = it
                }
    }

}
