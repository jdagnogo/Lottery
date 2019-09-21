package com.jdagnogo.exus.lottery.model

import java.io.Serializable

data class GameDefinition(
    val m_GameCode:Int,
    val m_NameEn: String,
    val m_NameGr: String,
    val m_AreaDefsArray: ArrayList<AreaDefinition>
):Serializable