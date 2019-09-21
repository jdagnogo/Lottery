package com.jdagnogo.exus.lottery.presenter

import com.jdagnogo.exus.LotteryApplication.Companion.data
import com.jdagnogo.exus.lottery.view.GameView

class GamePresenter (){
    private lateinit var gameView: GameView

    fun initialize(view: GameView) {
        gameView = view
    }

    fun fetchGames(){
        val games = data
        gameView.updateList(games)
    }
}