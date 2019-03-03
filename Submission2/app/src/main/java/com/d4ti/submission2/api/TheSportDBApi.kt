package com.d4ti.submission2.api

import android.net.Uri
import com.d4ti.submission2.BuildConfig

object TheSportDBApi {

    private const val idLeague = "4328"

    fun getLast(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventspastleague.php")
            .appendQueryParameter("l", idLeague)
            .build()
            .toString()
    }

    fun getNext2(league: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php?l=" + league
    }

    fun getNext(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("l", idLeague)
            .build()
            .toString()
    }

}