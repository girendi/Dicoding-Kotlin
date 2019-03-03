package com.d4ti.footballclub.main.Home

import com.d4ti.footballclub.model.Event

interface HomeView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}