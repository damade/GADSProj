package com.example.gadsproj.DataClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SkillIq(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("score")
    @Expose
    val score: Int,

    @SerializedName("country")
    @Expose
    val country: String,

    @SerializedName("badgeUrl")
    @Expose
    val badgeUrl: String

)

data class SkillIqResponse(

    val results: List<SkillIq>

)

