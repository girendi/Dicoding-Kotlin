package com.d4ti.submission2.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            textView {
                text = "Test"
            }
        }
    }
}