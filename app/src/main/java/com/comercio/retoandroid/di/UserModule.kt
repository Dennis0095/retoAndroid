package com.comercio.retoandroid.di

import com.comercio.data.repository.user.UserDataRepository
import com.comercio.domain.repository.user.IUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Singleton
    @Provides
    fun providesUserRepository(userDataRepository: UserDataRepository): IUserRepository {
        return userDataRepository
    }
}