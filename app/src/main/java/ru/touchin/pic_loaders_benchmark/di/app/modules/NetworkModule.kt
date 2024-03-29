package ru.touchin.pic_loaders_benchmark.di.app.modules

import com.touchin.pic_loaders_benchmark.BuildConfig
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import ru.touchin.pic_loaders_benchmark.api.ExceptionsInterceptor
import ru.touchin.pic_loaders_benchmark.api.UserApi
import ru.touchin.pic_loaders_benchmark.di.qualifiers.PublicApi
import ru.touchin.templates.logansquare.LoganSquareJsonFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private val CONVERTER_FACTORY = LoganSquareJsonFactory()
        private val CALL_ADAPTER_FACTORY = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
        private const val TIMEOUT = 30L
    }

    @Singleton
    @Provides
    fun provideUserApi(@PublicApi retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Singleton
    @PublicApi
    @Provides
    fun providePublicRetrofit(@PublicApi client: OkHttpClient) = buildRetrofitInstance(client, BuildConfig.API_URL)

    @Singleton
    @PublicApi
    @Provides
    fun providePublicClient(exceptionsInterceptor: ExceptionsInterceptor): OkHttpClient =
            buildPublicClient(exceptionsInterceptor)

    private fun buildRetrofitInstance(client: OkHttpClient, apiUrl: String): Retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client)
            .addCallAdapterFactory(CALL_ADAPTER_FACTORY)
            .addConverterFactory(CONVERTER_FACTORY)
            .build()

    private fun buildPublicClient(exceptionsInterceptor: ExceptionsInterceptor): OkHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                readTimeout(TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                addInterceptor(exceptionsInterceptor)
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                }
            }.build()

}
