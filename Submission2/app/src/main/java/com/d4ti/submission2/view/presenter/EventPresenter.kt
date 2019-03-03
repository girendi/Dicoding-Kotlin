package com.d4ti.submission2.view.presenter

import com.d4ti.submission2.api.ApiRepository
import com.d4ti.submission2.api.TheSportDBApi
import com.d4ti.submission2.model.EventResponse
import com.d4ti.submission2.view.interfaceView.EventView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventPresenter(private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson
) {
    fun getNextList() {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNext2("4328")),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.events)
            }
        }
    }

    fun getLastList() {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLast()),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.events)
            }
        }
    }
}