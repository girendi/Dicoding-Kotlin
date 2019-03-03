package com.d4ti.submission2.model

import com.google.gson.annotations.SerializedName

class Event (
    @SerializedName("idEvent") var idEvent: String? = null,
    @SerializedName("strEvent") var strEvent: String? = null,
    @SerializedName("strHomeTeam") var strHomeTeam: String? = null,
    @SerializedName("strAwayTeam") var strAwayTeam: String? = null,
    @SerializedName("intHomeScore") var intHomeScore: String? = null,
    @SerializedName("intAwayScore") var intAwayScore: String? = null,
    @SerializedName("strHomeGoalDetails") var strHomeGoalDetails: String? = null,
    @SerializedName("strAwayGoalDetails") var strAwayGoalDetails: String? = null,
    @SerializedName("dateEvent") var dateEvent: String? = null,
    @SerializedName("idHomeTeam") var idHomeTeam: String? = null,
    @SerializedName("idAwayTeam") var idAwayTeam: String? = null
    )