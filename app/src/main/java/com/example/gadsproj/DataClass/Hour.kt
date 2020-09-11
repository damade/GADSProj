package com.example.gadsproj.DataClass

data class Hour (
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String,

    )

data class HourResponse(
    val results: List<Hour>
)