package com.example.gadsproj.DataClass

data class SkillIq (
    val name: String,
    val score: Int,
    val country: String,
    val badgeUrl: String,

)

data class SkillIqResponse(
    val results: List<SkillIq>
)

