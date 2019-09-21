package com.jdagnogo.exus.lottery.view.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.jdagnogo.exus.lottery.R
import com.jdagnogo.exus.lottery.model.GameDefinition
import com.jdagnogo.exus.lottery.presenter.ThirdScreenPresenter
import com.jdagnogo.exus.lottery.view.ThirdView
import com.jdagnogo.exus.lottery.view.adapter.GameAdapter.Companion.GAMEDEFINITION
import kotlinx.android.synthetic.main.activity_third_screen.*
import kotlinx.android.synthetic.main.custom_alert_dialog.*
import java.util.*
import java.util.Locale.ENGLISH

class ThirdScreen : AppCompatActivity(), ThirdView {
    companion object {
        const val MAX_VALUE = 20
        const val MIN_VALUE = 1
        const val NUMBER = "NUMBER"
    }

    private val presenter = ThirdScreenPresenter()

    private var currentValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        // I did not have time to handle screen rotation
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)
        initViews()
    }

    fun createDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_alert_dialog)
        val picker = dialog.findViewById<NumberPicker>(R.id.number_picker)
        picker.value = currentValue
        picker.minValue = MIN_VALUE
        picker.maxValue = MAX_VALUE
        val button = dialog.findViewById<Button>(R.id.button_dialog)
        button.setOnClickListener {
            currentValue = picker.value
            third_screen_button.text =
                getString(R.string.third_screen_button1) + " = " + currentValue.toString()
            dialog.dismiss()
        }
        picker.value = currentValue
        dialog.show()
    }

    fun initViews() {
        val gameDefinition = intent.extras.get(GAMEDEFINITION) as GameDefinition?
        if (Locale.getDefault().getDisplayLanguage().equals(ENGLISH)) {
            third_screen_title.text = gameDefinition?.m_NameEn
        } else {
            third_screen_title.text = gameDefinition?.m_NameGr
        }
        third_screen_button.text =
            getString(R.string.third_screen_button1) + " = " + currentValue.toString()
        third_screen_button.setOnClickListener { createDialog() }
        third_screen_button2.setOnClickListener {
            val intent = Intent(this, LastScreenActivity::class.java)
            intent.putExtra(NUMBER, presenter.generateNumber())
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        }
    }


}
