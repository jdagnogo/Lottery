package com.jdagnogo.exus.lottery.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jdagnogo.exus.lottery.R
import com.jdagnogo.exus.lottery.model.GameDefinition
import com.jdagnogo.exus.lottery.view.activity.ThirdScreen


class GameAdapter : RecyclerView.Adapter<GameAdapter.GameListItem>() {
    companion object{
        const val GAMEDEFINITION = "GAMEDEFINITION"
    }
    lateinit var mContext: Context
    val mDataset = mutableListOf<GameDefinition>()

    class GameListItem(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListItem {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listview_item, parent, false)
        return GameListItem(view)
    }

    fun setContext(context: Context) {
        mContext = context
    }

    override fun getItemCount(): Int = mDataset.size

    override fun onBindViewHolder(holder: GameListItem, position: Int) {
        holder.title.setOnClickListener {
            val intent = Intent(mContext, ThirdScreen::class.java)
            intent.putExtra(GAMEDEFINITION,mDataset[position])
            mContext.startActivity(intent)
        }
        mDataset[position].apply {
            holder.title.text = m_NameGr
        }
    }
}