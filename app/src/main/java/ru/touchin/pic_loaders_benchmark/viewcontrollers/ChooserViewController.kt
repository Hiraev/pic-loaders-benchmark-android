package ru.touchin.pic_loaders_benchmark.viewcontrollers

import android.view.View
import android.widget.TextView
import com.touchin.pic_loaders_benchmark.BuildConfig
import com.touchin.pic_loaders_benchmark.R
import ru.touchin.extensions.setOnRippleClickListener
import ru.touchin.pic_loaders_benchmark.ImagePaths
import ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images.FrescoImagesViewController
import ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images.GlideOneImageViewController
import ru.touchin.pic_loaders_benchmark.viewcontrollers.different_images.PicassoImagesViewController
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.RecyclerViewController
import ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview.RecyclerViewState
import ru.touchin.roboswag.components.navigation.activities.NavigationActivity
import ru.touchin.roboswag.components.navigation.viewcontrollers.EmptyState
import ru.touchin.roboswag.components.navigation.viewcontrollers.ViewController

class ChooserViewController(
        creationContext: CreationContext
) : ViewController<NavigationActivity, EmptyState>(
        creationContext,
        R.layout.view_controller_chooser
) {

    init {
        findViewById<TextView>(R.id.view_controller_chooser_is_caching_enabled).text = BuildConfig.IMAGES_CACHING.toString()
        findViewById<View>(R.id.view_controller_chooser_clear_caches).setOnRippleClickListener {
            ImagePaths.invalidateAll(activity)
        }
        findViewById<View>(R.id.view_controller_chooser_glide).setOnRippleClickListener {
            activity.navigation.pushViewController(GlideOneImageViewController::class.java, EmptyState)
        }
        findViewById<View>(R.id.view_controller_chooser_fresco).setOnRippleClickListener {
            activity.navigation.pushViewController(FrescoImagesViewController::class.java, EmptyState)
        }
        findViewById<View>(R.id.view_controller_chooser_picasso).setOnRippleClickListener {
            activity.navigation.pushViewController(PicassoImagesViewController::class.java, EmptyState)
        }

        // LARGE PNG
        findViewById<View>(R.id.view_controller_chooser_recycler_glide_large_png).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.GLIDE,
                    RecyclerViewState.PicType.PNG,
                    RecyclerViewState.PicSize.LARGE
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_fresco_large_png).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.FRESCO,
                    RecyclerViewState.PicType.PNG,
                    RecyclerViewState.PicSize.LARGE
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_picasso_large_png).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.PICASSO,
                    RecyclerViewState.PicType.PNG,
                    RecyclerViewState.PicSize.LARGE
            ))
        }

        // SMALL PNG
        findViewById<View>(R.id.view_controller_chooser_recycler_glide_small_png).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.GLIDE,
                    RecyclerViewState.PicType.PNG,
                    RecyclerViewState.PicSize.SMALL
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_fresco_small_png).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.FRESCO,
                    RecyclerViewState.PicType.PNG,
                    RecyclerViewState.PicSize.SMALL
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_picasso_small_png).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.PICASSO,
                    RecyclerViewState.PicType.PNG,
                    RecyclerViewState.PicSize.SMALL
            ))
        }


        // LARGE JPEG
        findViewById<View>(R.id.view_controller_chooser_recycler_glide_large_jpg).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.GLIDE,
                    RecyclerViewState.PicType.JPEG,
                    RecyclerViewState.PicSize.LARGE
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_fresco_large_jpg).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.FRESCO,
                    RecyclerViewState.PicType.JPEG,
                    RecyclerViewState.PicSize.LARGE
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_picasso_large_jpg).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.PICASSO,
                    RecyclerViewState.PicType.JPEG,
                    RecyclerViewState.PicSize.LARGE
            ))
        }

        // SMALL JPEG
        findViewById<View>(R.id.view_controller_chooser_recycler_glide_small_jpg).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.GLIDE,
                    RecyclerViewState.PicType.JPEG,
                    RecyclerViewState.PicSize.SMALL
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_fresco_small_jpg).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.FRESCO,
                    RecyclerViewState.PicType.JPEG,
                    RecyclerViewState.PicSize.SMALL
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_picasso_small_jpg).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.PICASSO,
                    RecyclerViewState.PicType.JPEG,
                    RecyclerViewState.PicSize.SMALL
            ))
        }


        // LARGE WEBP
        findViewById<View>(R.id.view_controller_chooser_recycler_glide_large_webp).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.GLIDE,
                    RecyclerViewState.PicType.WEBP,
                    RecyclerViewState.PicSize.LARGE
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_fresco_large_webp).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.FRESCO,
                    RecyclerViewState.PicType.WEBP,
                    RecyclerViewState.PicSize.LARGE
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_picasso_large_webp).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.PICASSO,
                    RecyclerViewState.PicType.WEBP,
                    RecyclerViewState.PicSize.LARGE
            ))
        }

        // SMALL WEBP
        findViewById<View>(R.id.view_controller_chooser_recycler_glide_small_webp).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.GLIDE,
                    RecyclerViewState.PicType.WEBP,
                    RecyclerViewState.PicSize.SMALL
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_fresco_small_webp).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.FRESCO,
                    RecyclerViewState.PicType.WEBP,
                    RecyclerViewState.PicSize.SMALL
            ))
        }
        findViewById<View>(R.id.view_controller_chooser_recycler_picasso_small_webp).setOnRippleClickListener {
            activity.navigation.pushViewController(RecyclerViewController::class.java, RecyclerViewState(
                    RecyclerViewState.PicProcessor.PICASSO,
                    RecyclerViewState.PicType.WEBP,
                    RecyclerViewState.PicSize.SMALL
            ))
        }


    }

}
