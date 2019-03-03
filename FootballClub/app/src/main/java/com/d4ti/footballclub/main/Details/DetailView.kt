package com.d4ti.footballclub.main.Details

import com.d4ti.footballclub.model.Event
import com.d4ti.footballclub.model.Team

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showEventDetails(data: List<Event>, home: List<Team>, away: List<Team>)
}