package com.example.filmography.data.repository

import com.example.filmography.data.database.users.UserInfoDatabase
import com.example.filmography.data.remote.MovieRemouteSource
import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val localDataSource: UserInfoDatabase,
    private val remouteSource: MovieRemouteSource
) : UserInfoRepository {

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
}
