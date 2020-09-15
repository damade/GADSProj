package com.example.gadsproj.DataClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Hour(

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("hours")
    @Expose
    val hours: Int,

    @SerializedName("country")
    @Expose
    val country: String,

    @SerializedName("badgeUrl")
    @Expose
    val badgeUrl: String,

    )

data class HourResponse(
    val results: List<Hour>
)