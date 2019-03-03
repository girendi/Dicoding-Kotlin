package com.d4ti.submission2.view.interfaceView

import com.d4ti.submission2.model.Event

interface EventView{
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Event>)
}