package com.d4ti.submission2.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import com.d4ti.submission2.R
import com.d4ti.submission2.view.fragment.LastFragment
import com.d4ti.submission2.view.fragment.NextFragment
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            linearLayout {
                id = R.id.header_layout
                orientation = LinearLayout.HORIZONTAL

                button{
                    text = "Next"
                    id = R.id.btn_next
                    setOnClickListener {
                        val nextFragment = NextFragment.nextInstance()
                        addFragment(nextFragment)
                    }
                }.lparams(width = 0, height = wrapContent, weight = 2f)

                button{
                    text = "Last"
                    id = R.id.btn_last
                    setOnClickListener {
                        val lastFragment = LastFragment.lastInstance()
                        addFragment(lastFragment)
                    }
                }.lparams(width = 0, height = wrapContent, weight = 2f)

            }.lparams(width = matchParent, height = wrapContent)

            frameLayout {
                id = R.id.frame_layout

            }.lparams(width = matchParent, height = matchParent){
                below(R.id.header_layout)
            }

        }

        if (savedInstanceState == null){
            addFragment(NextFragment.nextInstance())
        }

    }

    private fun addFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}