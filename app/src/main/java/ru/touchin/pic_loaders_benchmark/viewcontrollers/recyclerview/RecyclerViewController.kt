package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.pic_loaders_benchmark.ImagePaths
import ru.touchin.pic_loaders_benchmark.utils.Timer
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.CoilImagesDelegate
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.FrescoImageDelegate
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.GlideImagesDelegate
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.delegates.PicassoImagesDelegate
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController

class RecyclerViewController(
        creationContext: CreationContext
) : ViewController<NavigationActivity, RecyclerViewState>(
        creationContext,
        R.layout.view_controller_recycler_images
) {

    init {
        Timer.resetTimer()
        Timer.onTimerChangeListener = ::onTimerChangeListener
        findViewById<RecyclerView>(R.id.view_controller_recycler_images_recyclerview).adapter =
                ListImagesAdapter().also {
                    it.addDelegate(
                            when (state.picProcessor) {
                                RecyclerViewState.PicProcessor.GLIDE -> GlideImagesDelegate()
                                RecyclerViewState.PicProcessor.FRESCO -> FrescoImageDelegate()
                                RecyclerViewState.PicProcessor.PICASSO -> PicassoImagesDelegate()
                                RecyclerViewState.PicProcessor.COIL -> CoilImagesDelegate()
                            }
                    )
                    it.submitList(ImagePaths.jpg_list)
                }
        findViewById<TextView>(R.id.view_controller_recycler_title).text = "${state.picProcessor} ${state.picType} ${state.picSize}"
    }

    override fun onPause() {
        when (state.picProcessor) {
            RecyclerViewState.PicProcessor.GLIDE -> ImagePaths.invalidateGlide(activity)
            RecyclerViewState.PicProcessor.FRESCO -> ImagePaths.invalidateFresco()
            RecyclerViewState.PicProcessor.PICASSO -> ImagePaths.invalidatePicasso()
            RecyclerViewState.PicProcessor.COIL -> ImagePaths.invalidateCoil()
        }
        super.onPause()
    }

    private fun onTimerChangeListener(count: Long, average: Double) {
        findViewById<TextView>(R.id.view_controller_recycler_images_completely_load).text = count.toString()
        findViewById<TextView>(R.id.view_controller_recycler_images_average_time).text = average.toString()
    }

}