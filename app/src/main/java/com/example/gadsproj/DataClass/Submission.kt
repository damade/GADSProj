package com.example.gadsproj.DataClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Submission {

    @SerializedName("email")
    @Expose
    val email: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("lastName")
    @Expose
    val lastName: String? = null

    @SerializedName("githubLink")
    @Expose
    val githubLink: String? = null

}
