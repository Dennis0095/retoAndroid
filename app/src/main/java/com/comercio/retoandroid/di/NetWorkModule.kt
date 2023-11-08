package com.comercio.retoandroid.di

import com.comercio.data.core.OkHttpLogger
import com.comercio.data.network.service.login.ILoginService
import com.comercio.data.network.service.user.IUserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    private var baseUrl: String = "http://demo4530381.mockable.io/"

    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(OkHttpLogger())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
        return buildRetrofit(okHttpClient)
    }

    @Provides
    fun provideLoginService(retrofit: Retrofit): ILoginService {
        return retrofit.create(ILoginService::class.java)
    }

    @Provides
    fun provideUserService(retrofit: Retrofit): IUserService {
        return retrofit.create(IUserService::class.java)
    }

    fun updateBaseUrl(newBaseUrl: String) {
        baseUrl = newBaseUrl
    }

    private fun buildRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}