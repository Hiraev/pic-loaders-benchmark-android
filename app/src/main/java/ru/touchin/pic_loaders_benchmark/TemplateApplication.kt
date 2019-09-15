package ru.touchin.pic_loaders_benchmark

import androidx.appcompat.app.AppCompatDelegate
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.touchin.pic_loaders_benchmark.BuildConfig
import ru.touchin.lifecycle.viewmodel.ViewModelFactory
import ru.touchin.lifecycle.viewmodel.ViewModelFactoryProvider
import ru.touchin.pic_loaders_benchmark.di.app.DaggerApplicationComponent
import ru.touchin.pic_loaders_benchmark.di.app.modules.ApplicationModule
import ru.touchin.roboswag.components.navigation.TouchinApp
import javax.inject.Inject

class TemplateApplication : TouchinApp(), ViewModelFactoryProvider {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()
        //TODO remove after init
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initializeDagger()
        initializeFresco()
        initializePicasso()
    }

    private fun initializeDagger() {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
                .inject(this)
    }

    private fun initializeFresco() {
        if (BuildConfig.IMAGES_CACHING) {
            Fresco.initialize(this)
        } else {
            val config = ImagePipelineConfig
                    .newBuilder(this)
                    .setDiskCacheEnabled(false)
                    .build()
            Fresco.initialize(this, config)
        }
    }

    private fun initializePicasso() {
    }

}
