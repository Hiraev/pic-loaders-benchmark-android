package ru.touchin.pic_loaders_benchmark

import android.content.Context
import android.os.AsyncTask
import com.bumptech.glide.Glide
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.picasso.Picasso

object ImagePaths {

    private const val numOfImages = 25

    val png_large = List(numOfImages) { "$images_path$large_dir${it + 1}$png_ext" }
    val jpg_large = List(numOfImages) { "$images_path$large_dir${it + 1}$jpg_ext" }
    val webp_large = List(numOfImages) { "$images_path$large_dir${it + 1}$webp_ext" }

    val png_small = List(numOfImages) { "$images_path$small_dir${it + 1}$png_ext" }
    val jpg_small = List(numOfImages) { "$images_path$small_dir${it + 1}$jpg_ext" }
    val webp_small = List(numOfImages) { "$images_path$small_dir${it + 1}$webp_ext" }

    private const val images_path = "https://github.com/Hiraev/pic-loaders-benchmark/raw/master/images/"
    private const val large_dir = "large/"
    private const val small_dir = "small/"
    private const val png_ext = ".png"
    private const val jpg_ext = ".jpg"
    private const val webp_ext = ".webp"

    fun invalidateAll(context: Context) {
        invalidateGlide(context)
        invalidateFresco()
        invalidatePicasso()
    }

    fun invalidateGlide(context: Context) {
        Glide.get(context).clearMemory()
        Invalidator(Glide.get(context)).execute()
    }

    fun invalidateFresco() {
        Fresco.getImagePipeline().clearCaches()
    }

    fun invalidatePicasso() {
        for (path in png_large + jpg_large + webp_large + png_small + jpg_small + webp_small) {
            Picasso.get().invalidate(path)
        }
    }

    private class Invalidator(private val glide: Glide) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            glide.clearDiskCache()
        }
    }

}
