package com.d4ti.submission2.api

import com.d4ti.submission2.BuildConfig

object TheSportDBApi {

    private const val idEvent = "4328"

    fun getLast(): String {
        return BuildConfig.BASE_URL + "api/v1/json/1/eventspastleague.php?id=" + idEvent
    }

    //https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328
    fun getNext(): String {
        return BuildConfig.BASE_URL + "api/v1/json/1/eventsnextleague.php?id=" + idEvent
    }

    //https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=441613
    fun getDetailEvent(idEvent: String?): String{
        return BuildConfig.BASE_URL + "api/v1/json/1/lookupevent.php?id=" + idEvent
    }

    //https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604
    fun getDetailTeam(idTeam: String?): String{
        return BuildConfig.BASE_URL + "api/v1/json/1/lookupteam.php?id=" + idTeam
    }
}