package com.example.gadsproj.Api

import com.example.gadsproj.DataClass.Hour
import com.example.gadsproj.DataClass.SkillIq
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/skilliq")
    fun getSkillLeaders(): Call<List<SkillIq>>

    @GET("/api/hours")
    fun getHourLeaders(): Call<List<Hour>>
}