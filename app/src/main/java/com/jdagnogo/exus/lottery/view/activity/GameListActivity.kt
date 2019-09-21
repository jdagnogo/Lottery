package com.jdagnogo.exus.lottery.view.activity

import android.os.Bundle
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jdagnogo.exus.lottery.R
import com.jdagnogo.exus.lottery.model.GameDefinition
import com.jdagnogo.exus.lottery.presenter.GamePresenter
import com.jdagnogo.exus.lottery.view.GameView
import com.jdagnogo.exus.lottery.view.adapter.GameAdapter
import kotlinx.android.synthetic.main.activity_random_number.*

class GameListActivity : AppCompatActivity(), GameView {

    private val presenter = GamePresenter()
    private val adapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
        presenter.initialize(this)
        initList()
        presenter.fetchGames()
    }

    fun initList() {
        adapter.setContext(this)
        val recyclerView = game_list
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    @UiThread
    override fun updateList(game: List<GameDefinition>) {
        adapter.mDataset.clear()
        adapter.mDataset.addAll(game)
        adapter.notifyDataSetChanged()
    }
}
