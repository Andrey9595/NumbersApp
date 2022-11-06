package ru.anb.numbers

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//TODO: Названия
class ThedActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_activity)
        val numberShowView = intent.getParcelableExtra<Numbers>(Intent.EXTRA_TEXT)
        val showActivity: TextView = findViewById(R.id.thed_text)
        showActivity.setText(numberShowView!!.number.toString())
        showActivity.setTextColor(numberShowView.color)
    }
}