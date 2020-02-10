package com.onemain.challenge.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DadJoke(@Json(name = "joke") val text: String)