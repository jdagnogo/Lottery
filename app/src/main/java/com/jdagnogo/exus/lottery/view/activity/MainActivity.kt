package com.jdagnogo.exus.lottery.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jdagnogo.exus.lottery.R
import com.jdagnogo.exus.lottery.presenter.MainPresenter
import com.jdagnogo.exus.lottery.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initialize(this)
        pick_random_number.setOnClickListener {
            // I think you said the I cannot use xml to handle the state but I cannot see a good way to do it without xml..
            // So I decided to fake using onClick and then restore state onResume.. This is ugly but I did not have time to search for a better way
            // We should use XMl like I did on cost estimation button
            pick_random_number.setBackgroundResource(R.drawable.button_blue_pressed)
            presenter.onRandomNumberClicked(this)
        }
    }

    override fun onResume() {
        super.onResume()
        pick_random_number.setBackgroundResource(R.drawable.button_blue)
    }
}
