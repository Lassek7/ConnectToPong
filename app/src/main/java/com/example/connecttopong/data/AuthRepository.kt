package com.example.connecttopong.data

import com.google.firebase.auth.AuthResult
import com.example.firebaseauthyt.util.Resource
import java.util.concurrent.Flow

interface AuthRepository {
    fun loginUser(email:String,password:String): Flow<Resource<AuthResult>>

}