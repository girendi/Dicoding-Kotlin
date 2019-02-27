package com.d4ti.submission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val descId = 3
        val POSITION= "position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent  = intent
        val list = intent.getParcelableExtra<Data>(POSITION)
        DetailActivityUI(list).setContentView(this)
    }


    class DetailActivityUI(var list: Data) : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView{
                    Glide.with(this).load(list.image).into(this)
                    id = DataUI.imageId
                    padding = dip(10)
                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView {
                    id = DataUI.nameId
                    text = list.name
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView {
                    id = descId
                    text = list.desc
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }
            }
        }
    }
}