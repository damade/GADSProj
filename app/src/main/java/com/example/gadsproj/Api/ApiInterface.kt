package com.example.gadsproj.Api

import com.example.gadsproj.DataClass.HourResponse
import com.example.gadsproj.DataClass.SkillIqResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface
{
    @GET("/api/hours")
    fun getHourLeaders(): Call<HourResponse>

    @GET("/api/skilliq")
    fun getSkillLeaders(): Call<SkillIqResponse>
}