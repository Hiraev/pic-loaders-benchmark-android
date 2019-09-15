package ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images

import android.widget.TextView
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.EmptyState
import ru.touchin.pic_loaders_benchmark.ImagePaths
import ru.touchin.pic_loaders_benchmark.extensions.glide

class GlideOneImageViewController(
        creationContext: CreationContext
) : TimerViewController<NavigationActivity, EmptyState>(
        creationContext,
        R.layout.view_controller_with_image
) {

    override val textView = findViewById<TextView>(R.id.view_controller_with_image_timer)

    override val numOfPictures: Int
        get() = 8

    init {
        glide(R.id.view_controller_with_image_logo, ImagePaths.png_small[0], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_png, ImagePaths.png_small[2], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_jpeg, ImagePaths.jpg_small[0], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_webp_left, ImagePaths.webp_small[0], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_webp_right, ImagePaths.webp_small[1], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_very_big_jpeg_1, ImagePaths.jpg_small[1], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_very_big_jpeg_2, ImagePaths.jpg_large[0], ::onResourceLoaded)
        glide(R.id.view_controller_with_image_very_big_jpeg_3, ImagePaths.jpg_large[2], ::onResourceLoaded)
    }

}
