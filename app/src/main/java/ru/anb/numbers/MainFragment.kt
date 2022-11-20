package ru.anb.numbers

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates


class MainFragment : Fragment() {
    companion object {
        const val KEY: String = "number"
    }
    private var mainNumber = 101
    private lateinit var adapter: NumbersAdapter
    private var numberOfColums by Delegates.notNull<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            numberOfColums = 3
        else
            numberOfColums = 4
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColums)
        if (savedInstanceState != null) {
            with(savedInstanceState) {

                mainNumber = getInt(KEY) + 1
            }
        }
        val numbers = fetchData()
        val obClass:(Numbers)->Unit =  { number : Numbers ->
            run {
                val bundle = bundleOf(KEY to number)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, OwnNumberFragment.newInstance(bundle)).addToBackStack(null)
                    .commit()
            }
        }


        adapter = NumbersAdapter(numbers, obClass)
        recyclerView.adapter = adapter
        val button: Button = view.findViewById(R.id.buttonPlus)
        button.setOnClickListener {
            adapter.itemCount + 1
            adapter.insertNumber()
        }
        val buttonMinus: Button = view.findViewById(R.id.buttonMinus)
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

