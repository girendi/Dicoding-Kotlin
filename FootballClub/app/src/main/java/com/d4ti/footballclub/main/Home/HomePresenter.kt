package com.d4ti.footballclub.main.Home

import com.d4ti.footballclub.api.ApiRepository
import com.d4ti.footballclub.api.TheSportDBApi
import com.d4ti.footballclub.model.EventResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class HomePresenter(private val view: HomeView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {
    fun getNextEvent(){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getNext()),
                EventResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }
        }
    }
}