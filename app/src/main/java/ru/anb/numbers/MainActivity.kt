package ru.anb.numbers

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    companion object {
         const val KEY: String = "EXTRA_NUMBER_KEY"
    }
    private var mainNumber = 101
    private lateinit var adapter: NumbersAdapter
    private var numberOfColums by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            numberOfColums = 3
        else
            numberOfColums = 4
        recyclerView.layoutManager = GridLayoutManager(this, numberOfColums)
        if (savedInstanceState != null) {
            with(savedInstanceState) {
                mainNumber = getInt(KEY) + 1
            }
        }
        val numbers = fetchData()
        val newNumberContract = registerForActivityResult(NewPostConract()) { result ->
            result ?: return@registerForActivityResult
        }

        val obClass =  { number: Numbers -> newNumberContract.launch(number) }
//        val obClass = object : NumbersClicked  { number: Numbers -> newNumberContract.launch(number) }

        adapter = NumbersAdapter(numbers, obClass)
        recyclerView.adapter = adapter
        val button: Button = findViewById(R.id.buttonPlus)
        button.setOnClickListener {
            adapter.itemCount + 1
            adapter.insertNumber()
        }
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        buttonMinus.setOnClickListener{
            adapter.itemCount - 1
            adapter.removedNumber()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, adapter.itemCount)

    }

    private fun fetchData(): ArrayList<Numbers> {
        val list = ArrayList<Numbers>()
        for (i in 1 until mainNumber) {
            val numberFetchData = Numbers(i)
            list.add(numberFetchData)
        }
        return list
    }
}