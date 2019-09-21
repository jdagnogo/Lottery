package com.jdagnogo.exus

import android.app.Application
import com.jdagnogo.exus.lottery.model.AreaDefinition
import com.jdagnogo.exus.lottery.model.GameDefinition

class LotteryApplication :Application(){

    companion object {
        lateinit var data: ArrayList<GameDefinition>
    }

    override fun onCreate() {
        super.onCreate()
        data = createData()
    }

    fun createData():ArrayList<GameDefinition>{
        val areaDefinition1 = AreaDefinition(5,45)
        val areaDefinition2 = AreaDefinition(1,20)
        val areaDefinitionList = arrayListOf(areaDefinition1,areaDefinition2)
        val tzokerGame = GameDefinition(5000,"TzokerGame","TzokerGame",areaDefinitionList)

        val areaDefinition3 = AreaDefinition(5,45)
        val areaDefinitionList2 = arrayListOf(areaDefinition3)
        val lottoGame = GameDefinition(5001,"Lotto","Lotto",areaDefinitionList2)
        return arrayListOf<GameDefinition>(tzokerGame,lottoGame)
    }
}