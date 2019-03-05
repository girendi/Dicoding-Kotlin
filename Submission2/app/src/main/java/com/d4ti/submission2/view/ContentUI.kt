package com.d4ti.submission2.view

import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.d4ti.submission2.R
import org.jetbrains.anko.*

class ContentUI : AnkoComponent<ViewGroup> {
    override fun createView(view: AnkoContext<ViewGroup>) = with(view) {
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
                textColor = R.color.colorYellow
                textSize = 18f
                gravity = Gravity.CENTER
                setTypeface(null, Typeface.BOLD)
            }.lparams(width = matchParent, height = wrapContent){
                bottomMargin = dip(5)
            }

            linearLayout {
                lparams(width = wrapContent, height = matchParent){
                    bottomMargin = dip(8)
                }
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_HORIZONTAL

                textView {
                    id = R.id.txt_hometeam
                    textSize = 20f
                    textColor = R.color.colorBlack
                }.lparams(width = wrapContent, height = wrapContent)

                textView {
                    id = R.id.txt_homescore
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams(width = wrapContent, height = wrapContent){
                    leftMargin = dip(8)
                }

                textView {
                    id = R.id.txt_versus
                    text = "Vs"
                    textSize = 16f
                    gravity = Gravity.CENTER
                }.lparams(width = wrapContent, height = wrapContent){
                    leftMargin = dip(4)
                }

                textView {
                    id = R.id.txt_awayscore
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams(width = wrapContent, height = wrapContent){
                    leftMargin = dip(4)
                }

                textView {
                    id = R.id.txt_awayteam
                    textSize = 20f
                    textColor = R.color.colorBlack
                }.lparams(width = wrapContent, height = wrapContent){
                    leftMargin = dip(8)
                }
            }

        }
    }

}