package ru.touchin.pic_loaders_benchmark.di.app

import dagger.Component
import ru.touchin.pic_loaders_benchmark.TemplateApplication
import ru.touchin.pic_loaders_benchmark.di.app.modules.ApplicationModule
import ru.touchin.pic_loaders_benchmark.di.app.modules.NetworkModule
import ru.touchin.pic_loaders_benchmark.di.app.modules.PersistentModule
import ru.touchin.pic_loaders_benchmark.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, PersistentModule::class, ViewModelModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(application: TemplateApplication)

}
