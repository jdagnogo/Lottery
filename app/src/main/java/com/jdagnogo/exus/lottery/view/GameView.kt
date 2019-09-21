package com.jdagnogo.exus.lottery.view

import com.jdagnogo.exus.lottery.model.GameDefinition

interface GameView {
    fun updateList(games : List<GameDefinition>)
}