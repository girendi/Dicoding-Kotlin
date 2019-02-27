package com.d4ti.submission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var dataItem : MutableList<Data> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        MainActivityUI(dataItem).setContentView(this)
    }

    class MainActivityUI(var dataItem : MutableList<Data> = mutableListOf()) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

                recyclerView {
                    lparams(matchParent, matchParent)
                    layoutManager = LinearLayoutManager(context)
                    adapter = DataAdapter(dataItem){
                        startActivity<DetailActivity>(DetailActivity.POSITION to it)
                    }
                }
            }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_info)

        dataItem.clear()

        for (i in name.indices){
            dataItem.add(Data(name[i], image.getResourceId(i,0), desc[i] ))
        }

        image.recycle()

    }
}