package com.example.filmography.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmography.data.database.users.UserInfo

@Database(
    version = 1,
    entities = [UserInfo::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}