package ru.touchin.pic_loaders_benchmark.di.app.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.touchin.roboswag.components.utils.storables.PreferenceUtils
import ru.touchin.roboswag.core.observables.storable.NonNullStorable
import ru.touchin.pic_loaders_benchmark.di.qualifiers.SessionStorable
import ru.touchin.pic_loaders_benchmark.persistence.Database
import javax.inject.Singleton

@Module
class PersistentModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database = Room
        .databaseBuilder(context, Database::class.java, "database")
        .build()

    @Singleton
    @Provides
    @SessionStorable
    fun provideSessionStorable(sharedPreferences: SharedPreferences): NonNullStorable<String, String, String> =
        PreferenceUtils.stringStorable("MIDDLE_SESSION", sharedPreferences, "")

}
