package com.example.filmography.room

import androidx.room.*
import com.example.filmography.data.database.users.UserInfo

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserInfo)

    @Query("SELECT * FROM users WHERE login = :login")
    suspend fun getUser(login: String): UserInfo?

    @Update
    suspend fun update(user: UserInfo)
}
