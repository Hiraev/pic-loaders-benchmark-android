package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController
import ru.touchin.pic_loaders_benchmark.ImagePaths
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.FrescoImageDelegate
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.GlideImagesDelegate
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.PicassoImagesDelegate

class RecyclerViewController(
        creationContext: CreationContext
) : ViewController<NavigationActivity, RecyclerViewState>(
        creationContext,
        R.layout.view_controller_recycler_images
) {

    init {
        findViewById<RecyclerView>(R.id.view_controller_recycler_images_recyclerview).adapter =
                ListImagesAdapter().also {
                    it.addDelegate(
                            when (state.picProcessor) {
                                RecyclerViewState.PicProcessor.GLIDE -> GlideImagesDelegate()
                                RecyclerViewState.PicProcessor.FRESCO -> FrescoImageDelegate()
                                RecyclerViewState.PicProcessor.PICASSO -> PicassoImagesDelegate()
                            }
                    )
                    it.submitList(
                            when (state.picType to state.picSize) {
                                RecyclerViewState.PicType.JPEG to RecyclerViewState.PicSize.LARGE -> ImagePaths.jpg_large
                                RecyclerViewState.PicType.JPEG to RecyclerViewState.PicSize.SMALL -> ImagePaths.jpg_small
                                RecyclerViewState.PicType.PNG to RecyclerViewState.PicSize.LARGE -> ImagePaths.png_large
                                RecyclerViewState.PicType.PNG to RecyclerViewState.PicSize.SMALL -> ImagePaths.png_small
                                RecyclerViewState.PicType.WEBP to RecyclerViewState.PicSize.LARGE -> ImagePaths.webp_large
                                RecyclerViewState.PicType.WEBP to RecyclerViewState.PicSize.SMALL -> ImagePaths.webp_small
                                else -> emptyList()
                            }
                    )
                }
        findViewById<TextView>(R.id.view_controller_recycler_title).text = "${state.picProcessor} ${state.picType} ${state.picSize}"

    }

    override fun onPause() {
        when (state.picProcessor) {
            RecyclerViewState.PicProcessor.GLIDE -> ImagePaths.invalidateGlide(activity)
            RecyclerViewState.PicProcessor.FRESCO -> ImagePaths.invalidateFresco()
            RecyclerViewState.PicProcessor.PICASSO -> ImagePaths.invalidatePicasso()
        }
        super.onPause()
    }

}