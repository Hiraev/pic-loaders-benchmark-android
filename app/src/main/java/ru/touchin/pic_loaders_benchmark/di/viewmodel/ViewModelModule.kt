package ru.touchin.pic_loaders_benchmark.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.touchin.pic_loaders_benchmark.viewmodel.StartupViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartupViewModel::class)
    fun bindStartupViewModel(viewModel: StartupViewModel): ViewModel

}
