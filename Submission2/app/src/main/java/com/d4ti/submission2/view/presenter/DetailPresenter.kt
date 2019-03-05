package com.d4ti.submission2.view.presenter

import com.d4ti.submission2.api.ApiRepository
import com.d4ti.submission2.api.TheSportDBApi
import com.d4ti.submission2.model.EventResponse
import com.d4ti.submission2.model.TeamResponse
import com.d4ti.submission2.view.interfaceView.DetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view: DetailView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson) {
    fun getEventDetail(idEvent: String?, idHomeTeam: String?, idAwayTeam: String?){
        view.showLoading()

        doAsync {
            val dataEvent = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailEvent(idEvent)),
                EventResponse::class.java
            )

            val dataHome = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailTeam(idHomeTeam)),
                TeamResponse::class.java)

            val dataAway = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailTeam(idAwayTeam)),
                TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showEventList(dataEvent.events, dataHome.teams, dataAway.teams)
            }
        }
    }
}