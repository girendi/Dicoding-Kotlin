package com.d4ti.footballclub.main.Home

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.d4ti.footballclub.R
import com.d4ti.footballclub.R.id.*
import com.d4ti.footballclub.model.Event
import org.jetbrains.anko.*

class HomeAdapter(private val events: List<Event>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(EventUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindItem(events[position])
    }

}

class EventUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent){
                    topMargin = dip(10)
                    leftMargin = dip(10)
                    rightMargin = dip(10)
                }
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER

                textView {
                    id = R.id.txt_schedule
                    textSize = 18f
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    bottomMargin = dip(5)
                }

                linearLayout {
                    lparams(width = wrapContent, height = matchParent)
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    textView {
                        id = R.id.txt_hometeam
                        textSize = 20f
                    }.lparams(width = wrapContent, height = wrapContent)

                    textView {
                        id = R.id.txt_homescore
                        textSize = 24f
                    }.lparams(width = wrapContent, height = wrapContent)

                    textView {
                        id = R.id.txt_versus
                        text = "Vs"
                        textSize = 16f
                    }.lparams(width = wrapContent, height = wrapContent)

                    textView {
                        id = R.id.txt_awayscore
                        textSize = 24f
                    }.lparams(width = wrapContent, height = wrapContent)

                    textView {
                        id = R.id.txt_awayteam
                        textSize = 20f
                    }.lparams(width = wrapContent, height = wrapContent)
                }

            }
        }
    }
}

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val timeSchedule: TextView = view.find(txt_schedule)
    private val homeTeam: TextView = view.find(txt_hometeam)
    private val homeScore: TextView = view.find(txt_homescore)
    private val awayScore: TextView = view.find(txt_awayscore)
    private val awayTeam: TextView = view.find(txt_awayteam)

    fun bindItem(event: Event){
        timeSchedule.text = event.dateEvent
        homeTeam.text = event.strHomeTeam
        homeScore.text = event.intHomeScore
        awayTeam.text = event.strAwayTeam
        awayScore.text = event.intAwayScore
    }
}