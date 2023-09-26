package com.example.filmography.data.repository

import com.example.filmography.data.database.users.UserInfo
import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import com.example.filmography.room.UserDao
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(private val userDao: UserDao) :
    UserInfoRepository {

    override fun getUserLogin(): String {
        TODO("Not yet implemented")
    }

    override fun getUserPassword(): String {
        TODO("Not yet implemented")
    }

    override fun setUserEmail(email: String) {
        TODO("Not yet implemented")
    }

    override fun setUserLogin(email: String) {
        TODO("Not yet implemented")
    }

    override fun setUserPassword(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addUser(login: String, password: String, email: String) {
        val user = UserInfo(login, password, email)
        userDao.insert(user)
    }

    override suspend fun loginUser(login: String, password: String): Boolean {
        val user = userDao.getUser(login)
        if (user != null && user.password == password) {
            return true
        } else {
            return false
        }
    }
}