package com.d4ti.submission2.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.d4ti.submission2.R
import com.d4ti.submission2.model.Favorite
import com.d4ti.submission2.view.ContentUI
import com.d4ti.submission2.view.DetailActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class FavoriteAdapter(private val favorites: List<Favorite>) : RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(ContentUI().createView(AnkoContext.create(parent.context, parent)))
    }
    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(favorites[position])
    }
    override fun getItemCount(): Int = favorites.size
}

class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val timeSchedule: TextView = view.find(R.id.txt_schedule)
    private val homeTeam: TextView = view.find(R.id.txt_hometeam)
    private val homeScore: TextView = view.find(R.id.txt_homescore)
    private val awayScore: TextView = view.find(R.id.txt_awayscore)
    private val awayTeam: TextView = view.find(R.id.txt_awayteam)

    fun bindItem(favorites: Favorite){
        timeSchedule.text = favorites.date
        homeTeam.text = favorites.homeName
        homeScore.text = favorites.homeScore
        awayTeam.text = favorites.awayName
        awayScore.text = favorites.awayScore

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailActivity>(
                ctx.getString(R.string.item_eventdetail_id) to favorites.eventId,
                ctx.getString(R.string.item_home_id) to favorites.homeId,
                ctx.getString(R.string.item_away_id) to favorites.awayId
            )
        }
    }
}