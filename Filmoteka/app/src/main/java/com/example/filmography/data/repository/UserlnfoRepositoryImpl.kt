package com.example.filmography.data.repository

import com.example.filmography.data.database.users.UserInfo
import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import com.example.filmography.room.UserDao
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(private val userDao: UserDao) :
    UserInfoRepository {
    override suspend fun addUser(login: String, password: String, email: String) {
        val user = UserInfo(login, password, email)
        userDao.insert(user)
    }

    override suspend fun loginUser(login: String, password: String): Boolean {
        val user = userDao.getUser(login)
        return user != null && user.password == password
    }
}