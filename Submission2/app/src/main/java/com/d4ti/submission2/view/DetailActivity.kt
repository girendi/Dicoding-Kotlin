package com.d4ti.submission2.view

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.d4ti.submission2.R
import com.d4ti.submission2.R.color.*
import com.d4ti.submission2.model.Event
import com.d4ti.submission2.model.Team
import com.d4ti.submission2.R.string.*
import com.d4ti.submission2.api.ApiRepository
import com.d4ti.submission2.util.invisible
import com.d4ti.submission2.util.visible
import com.d4ti.submission2.view.interfaceView.DetailView
import com.d4ti.submission2.view.presenter.DetailPresenter
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var eventDetail: Event
    private lateinit var badgeHome: Team
    private lateinit var badgeAway: Team

    private lateinit var tvDateEvent : TextView
    private lateinit var tvHomeName : TextView
    private lateinit var tvAwayName : TextView
    private lateinit var tvHomeScore : TextView
    private lateinit var tvAwayScore : TextView
    private lateinit var tvHomeGoal : TextView
    private lateinit var tvAwayGoal : TextView
    private lateinit var tvHomeShot : TextView
    private lateinit var tvAwayShot : TextView

    private lateinit var homeBadge: ImageView
    private lateinit var awayBadge: ImageView

    private var itemHomeId: String? = null
    private var itemAwayId: String? = null
    private lateinit var idEventDetail: String

    private lateinit var presenter: DetailPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.extras != null) {
            idEventDetail = intent.getStringExtra(getString(item_eventdetail_id))
            itemHomeId = intent.getStringExtra(getString(item_home_id))
            itemAwayId = intent.getStringExtra(getString(item_away_id))
        }

        swipeRefresh = swipeRefreshLayout {
            setColorSchemeResources(
                colorAccent,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)
            linearLayout {
                lparams(width = matchParent, height = matchParent)
                orientation = LinearLayout.VERTICAL

                tvDateEvent = textView {
                    id  = R.id.txt_schedule
                    text = "Test"
                    textSize = 18f
                    gravity = Gravity.CENTER_HORIZONTAL
                    setTypeface(null, Typeface.BOLD)
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = dip(8)
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    homeBadge = imageView().lparams(width = dip(100), height = dip(100)){
                        gravity = Gravity.CENTER
                        topPadding = dip(8)
                        rightMargin = dip(8)
                    }

                    tvHomeScore = textView {
                        gravity = Gravity.CENTER
                        textSize = 48f
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(width = wrapContent, height = wrapContent)

                    textView {
                        text = "Vs"
                        textSize = 24f
                    }.lparams(width = wrapContent, height = wrapContent) {
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }

                    tvAwayScore = textView {
                        gravity = Gravity.CENTER
                        textSize = 48f
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(width = wrapContent, height = wrapContent)

                    awayBadge = imageView().lparams(width = dip(100), height = dip(100)){
                        gravity = Gravity.CENTER
                        topPadding = dip(8)
                        leftMargin = dip(8)
                    }
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    tvHomeName = textView{
                        text = "Home"
                        id = R.id.txt_hometeam
                        textColor = R.color.colorPrimary
                        textSize = 20f
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(width = 0, height = wrapContent, weight = 2f)

                    tvAwayName = textView{
                        text = "Away"
                        id = R.id.txt_awayteam
                        textColor = R.color.colorPrimary
                        textSize = 20f
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(null, Typeface.BOLD)
                    }.lparams(width = 0, height = wrapContent, weight = 2f)
                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        bottomMargin = dip(8)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    tvHomeGoal = textView {
                        id = R.id.txt_homegoal
                        gravity = Gravity.CENTER_HORIZONTAL
                        textSize = 20f
                        textColor = R.color.colorBlack
                    }.lparams(width = 0, height = wrapContent, weight = 2f)

                    textView {
                        text = "Goals"
                        gravity = Gravity.CENTER_HORIZONTAL
                        textSize = 24f
                    }.lparams(width = 0, height = wrapContent, weight = 1f) {
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }

                    tvAwayGoal = textView {
                        id = R.id.txt_awaygoal
                        gravity = Gravity.CENTER_HORIZONTAL
                        textSize = 20f
                        textColor = R.color.colorBlack
                    }.lparams(width = 0, height = wrapContent, weight = 2f)

                }

                linearLayout {
                    lparams(width = matchParent, height = wrapContent){
                        bottomMargin = dip(8)
                    }
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    tvHomeShot = textView {
                        id = R.id.txt_homeshot
                        textSize = 20f
                        textColor = R.color.colorBlack
                        gravity = Gravity.CENTER_HORIZONTAL
                    }.lparams(width = wrapContent, height = wrapContent)

                    textView {
                        text = "Shots"
                        textSize = 24f
                    }.lparams(width = wrapContent, height = wrapContent) {
                        leftMargin = dip(8)
                        rightMargin = dip(8)
                    }

                    tvAwayShot = textView {
                        id = R.id.txt_awayshot
                        textSize = 20f
                        textColor = R.color.colorBlack
                        gravity = Gravity.CENTER_HORIZONTAL
                    }.lparams(width = wrapContent, height = wrapContent)

                }
                progressBar = progressBar {
                    id = R.id.pbDetailEvent
                }.lparams {
                    gravity = Gravity.CENTER
                }
            }
        }

        getEventDetail()
    }

    private fun bindView(){
        swipeRefresh.isRefreshing = false
        tvDateEvent.text = eventDetail.dateEvent
        tvHomeName.text = eventDetail.strHomeTeam
        tvAwayName.text = eventDetail.strAwayTeam
        tvHomeScore.text = eventDetail.intHomeScore
        tvAwayScore.text = eventDetail.intAwayScore
        tvHomeGoal.text = setPlayerTeam(eventDetail.strHomeGoalDetails)
        tvAwayGoal.text = setPlayerTeam(eventDetail.strAwayGoalDetails)
        tvHomeShot.text = eventDetail.intHomeShots
        tvAwayShot.text = eventDetail.intAwayShots

        Picasso.get().load(badgeHome.strTeamBadge).into(homeBadge)
        Picasso.get().load(badgeAway.strTeamBadge).into(awayBadge)
    }

    private fun setPlayerTeam(playerName: String?): String? {
        val bulkPlayer = playerName?.split(";".toRegex())?.dropLastWhile {
            it.isEmpty()
        }?.map { it.trim() }?.toTypedArray()?.joinToString("\n")

        return bulkPlayer
    }

    private fun getEventDetail(){
        presenter = DetailPresenter(this, ApiRepository(), Gson())
        presenter.getEventDetail(idEventDetail, itemHomeId, itemAwayId)

        swipeRefresh.onRefresh {
            presenter.getEventDetail(idEventDetail, itemHomeId, itemAwayId)
        }
    }

    override fun hideLoading() {
        progressBar
            .invisible()
    }

    override fun showLoading() {
        progressBar
            .visible()
    }

    override fun showEventList(data: List<Event>, home: List<Team>, away: List<Team>) {
        eventDetail = data[0]
        badgeHome = home[0]
        badgeAway = away[0]

        bindView()
    }
}