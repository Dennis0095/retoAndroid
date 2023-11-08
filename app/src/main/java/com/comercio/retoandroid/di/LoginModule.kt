package com.comercio.retoandroid.di

import com.comercio.data.repository.login.LoginDataRepository
import com.comercio.domain.repository.login.ILoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Singleton
    @Provides
    fun providesLoginRepository(loginDataRepository: LoginDataRepository): ILoginRepository {
        return loginDataRepository
    }
}