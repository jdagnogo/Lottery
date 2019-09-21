package com.jdagnogo.exus.lottery.presenter

import android.content.Context
import android.content.Intent
import com.jdagnogo.exus.lottery.view.MainView
import com.jdagnogo.exus.lottery.view.activity.GameListActivity


class MainPresenter() {
    private lateinit var mainView: MainView

    fun initialize(view: MainView) {
        mainView = view
    }

    fun onRandomNumberClicked(context: Context){
        val intent = Intent(context, GameListActivity::class.java)
        context.startActivity(intent)
    }

}