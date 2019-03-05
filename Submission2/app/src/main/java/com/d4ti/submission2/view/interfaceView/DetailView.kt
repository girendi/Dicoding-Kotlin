package com.d4ti.submission2.view.interfaceView

import com.d4ti.submission2.model.Event
import com.d4ti.submission2.model.Team

interface DetailView {
    fun hideLoading()
    fun showLoading()
    fun showEventList(data: List<Event>, home: List<Team>, away: List<Team>)
}