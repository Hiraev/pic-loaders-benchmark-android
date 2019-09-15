package ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images

import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.EmptyState
import ru.touchin.pic_loaders_benchmark.ImagePaths
import ru.touchin.pic_loaders_benchmark.extensions.picasso

class PicassoImagesViewController(
        creationContext: CreationContext
) : TimerViewController<NavigationActivity, EmptyState>(
        creationContext,
        R.layout.view_controller_with_image
) {

    override val textView = findViewById<TextView>(R.id.view_controller_with_image_timer)

    override val numOfPictures: Int
        get() = 8

    init {
        Picasso.get().setIndicatorsEnabled(true)
        picasso(R.id.view_controller_with_image_logo, ImagePaths.png_small[0], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_png, ImagePaths.png_small[2], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_jpeg, ImagePaths.jpg_small[0], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_webp_left, ImagePaths.webp_small[0], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_webp_right, ImagePaths.webp_small[1], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_very_big_jpeg_1, ImagePaths.jpg_small[1], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_very_big_jpeg_2, ImagePaths.jpg_large[0], ::onResourceLoaded)
        picasso(R.id.view_controller_with_image_very_big_jpeg_3, ImagePaths.jpg_large[2], ::onResourceLoaded)
    }

    override fun onPause() {
        super.onPause()
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_logo))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_png))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_jpeg))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_webp_left))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_webp_right))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_very_big_jpeg_1))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_very_big_jpeg_2))
        Picasso.get().cancelRequest(findViewById<ImageView>(R.id.view_controller_with_image_very_big_jpeg_3))
    }

}