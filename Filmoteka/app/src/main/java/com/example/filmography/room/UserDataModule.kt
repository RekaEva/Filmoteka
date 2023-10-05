package com.example.filmography.room

import android.content.Context
import androidx.room.Room
import com.example.filmography.data.repository.UserInfoRepositoryImpl
import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserDataModule {
    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserInfoRepository {
        return UserInfoRepositoryImpl(userDao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "userdatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }
}
