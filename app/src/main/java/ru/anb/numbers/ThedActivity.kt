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
        val numberTextView: TextView = findViewById(R.id.thed_text)
        numberTextView.text = numberShowView!!.number.toString()
        numberTextView.setTextColor(numberShowView.color)
    }
}

////
//  JAVA: int a;
//  Kotlin: val a: Int = 0
/////

