package com.d4ti.submission1

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class DataUI : AnkoComponent<ViewGroup>{

    companion object {
        val nameId = 1
        val imageId = 2
    }


    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = imageId
                imageResource = R.drawable.img_barca
            }.lparams(dip(50), dip(50))

            textView{
                id = nameId
                text = "Barcelona FC"
                padding = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }.lparams(matchParent, wrapContent)
        }
    }

}