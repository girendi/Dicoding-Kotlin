package com.d4ti.footballclub.main.Details

import com.d4ti.footballclub.api.ApiRepository
import com.d4ti.footballclub.api.TheSportDBApi
import com.d4ti.footballclub.model.EventResponse
import com.d4ti.footballclub.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class DetailPresenter(private val view: DetailView,
                      private val apiRequest: ApiRepository,
                      private val gson: Gson){
    fun getEventDetail(idEvent: String?, idHomeTeam : String?, idAwayTeam : String?){
        view.showLoading()

        doAsync {
            val eventDetail = gson.fromJson(apiRequest
                .doRequest(TheSportDBApi.getEventDetails(idEvent)),
                EventResponse::class.java
            )
            val homeTeam = gson.fromJson(apiRequest
                .doRequest(TheSportDBApi.getTeamDetails(idHomeTeam)),
                TeamResponse::class.java)

            val awayTeam = gson.fromJson(apiRequest
                .doRequest(TheSportDBApi.getTeamDetails(idAwayTeam)),
                TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showEventDetails(eventDetail.events, homeTeam.teams, awayTeam.teams)
            }
        }
    }
}