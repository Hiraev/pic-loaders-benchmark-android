package ru.touchin.pic_loaders_benchmark.extensions

import android.os.Parcelable
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import com.touchin.pic_loaders_benchmark.BuildConfig
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController

private val emptyAction = Unit

fun <T : FragmentActivity, P : Parcelable> ViewController<T, P>.glide(
        @IdRes id: Int,
        path: String,
        onLoad: () -> Unit = ::emptyAction
) = Glide.with(view)
        .load(path)
        .placeholder(R.drawable.placeholder_loading)
        .error(R.drawable.placeholder_error)
        .centerCrop()
        .disableCachingIfNeeded()
        .onLoad(onLoad)
        .into(findViewById(id))

/**
 * Don't forget call cancelRequest to suppress memory leaks
 */
fun <T : FragmentActivity, P : Parcelable> ViewController<T, P>.picasso(
        @IdRes id: Int,
        path: String,
        onLoad: () -> Unit = ::emptyAction
) = Picasso.get()
        .load(path)
        .disableCachingIfNeeded()
        .placeholder(R.drawable.placeholder_loading)
        .error(R.drawable.placeholder_error)
        .fit()
        .centerCrop()
        .into(view.findViewById(id), onLoad(onLoad))

fun glide(
        view: View,
        path: String,
        @IdRes id: Int,
        onLoad: () -> Unit
) = Glide.with(view)
        .load(path)
        .placeholder(R.drawable.placeholder_loading)
        .error(R.drawable.placeholder_error)
        .centerCrop()
        .disableCachingIfNeeded()
        .onLoad(onLoad)
        .into(view.findViewById(id))

fun picasso(
        view: View,
        path: String,
        @IdRes id: Int,
        onLoad: () -> Unit
) = Picasso.get()
        .load(path)
        .placeholder(R.drawable.placeholder_loading)
        .error(R.drawable.placeholder_error)
        .fit()
        .centerCrop()
        .disableCachingIfNeeded()
        .into(view.findViewById(id), onLoad(onLoad))

private fun <T> RequestBuilder<T>.onLoad(onLoad: () -> Unit) =
        addListener(object : RequestListener<T> {
            override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target:
                    Target<T>?,
                    isFirstResource: Boolean
            ): Boolean = false

            override fun onResourceReady(
                    resource: T?,
                    model: Any?,
                    target: Target<T>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
            ): Boolean {
                onLoad.invoke()
                return false
            }
        })

private fun <T> RequestBuilder<T>.disableCachingIfNeeded() =
        if (!BuildConfig.IMAGES_CACHING) {
            diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
        } else this

private fun RequestCreator.disableCachingIfNeeded() =
        if (!BuildConfig.IMAGES_CACHING) {
            memoryPolicy(MemoryPolicy.NO_CACHE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
        } else this

private fun onLoad(onLoad: () -> Unit) = object : Callback {
    override fun onSuccess() = onLoad.invoke()
    override fun onError(e: Exception?) = Unit
}

