package com.example.filmography.room

import android.content.Context
import androidx.room.Room
import com.example.filmography.data.repository.UserInfoRepositoryImpl
import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import dagger.Module
import dagger.Provides

@Module
class UserDataModule {
    @Provides
    fun provideUserRepository(userDao: UserDao): UserInfoRepository {
        return UserInfoRepositoryImpl(userDao)
    }

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "userdatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }
}
