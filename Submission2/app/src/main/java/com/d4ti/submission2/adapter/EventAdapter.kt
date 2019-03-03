package com.d4ti.submission2.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.d4ti.submission2.R.string.*
import com.d4ti.submission2.R.id.*
import com.d4ti.submission2.model.Event
import com.d4ti.submission2.view.ContentUI
import com.d4ti.submission2.view.DetailActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class EventAdapter(private val events: List<Event>) : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(ContentUI().createView(AnkoContext.create(parent.context, parent)))
    }
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(events[position])
    }
    override fun getItemCount(): Int = events.size
}

class EventViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val timeSchedule: TextView = view.find(txt_schedule)
    private val homeTeam: TextView = view.find(txt_hometeam)
    private val homeScore: TextView = view.find(txt_homescore)
    private val awayScore: TextView = view.find(txt_awayscore)
    private val awayTeam: TextView = view.find(txt_awayteam)

    fun bindItem(events: Event){
        timeSchedule.text = events.dateEvent
        homeTeam.text = events.strHomeTeam
        homeScore.text = events.intHomeScore
        awayTeam.text = events.strAwayTeam
        awayScore.text = events.intAwayScore

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailActivity>(
                ctx.getString(item_eventdetail_id) to events.idEvent,
                ctx.getString(item_home_id) to events.idHomeTeam,
                ctx.getString(item_away_id) to events.idAwayTeam
            )
        }
    }
}
