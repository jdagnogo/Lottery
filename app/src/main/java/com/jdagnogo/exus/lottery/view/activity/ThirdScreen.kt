package com.jdagnogo.exus.lottery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jdagnogo.exus.lottery.R
import com.jdagnogo.exus.lottery.view.adapter.GameAdapter.Companion.GAMEDEFINITION

class ThirdScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)
        val gameDefinition = intent.extras.get(GAMEDEFINITION)
    }
}
