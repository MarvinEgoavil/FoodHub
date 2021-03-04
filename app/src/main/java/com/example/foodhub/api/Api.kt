package com.example.foodhub.api

import com.example.foodhub.models.DefaultResponse
import com.example.foodhub.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("register")

    fun createUser (
        @Field("name") name:String,
        @Field("password") pasword:String,
        @Field("repassword") repasword:String,
        @Field("email") email:String
    ): Call<DefaultResponse>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("email")email:String,
        @Field("password")password:String
    ):Call<LoginResponse>
}