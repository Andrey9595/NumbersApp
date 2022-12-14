package ru.anb.numbers

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumbersAdapter(private val clicked: (Numbers) -> Unit) :
    RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {

    private val numbers = mutableListOf<Numbers>()

    class NumbersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var numberTextView: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.number_activity, parent, false)
        return NumbersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.numberTextView.setTextColor(Color.BLUE)
        } else
            holder.numberTextView.setTextColor(Color.RED)
        val items = numbers[position]
        holder.numberTextView.text = items.number.toString()
        holder.numberTextView.setOnClickListener {
            clicked(items)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Numbers>) {
        numbers.clear()
        numbers.addAll(data)
        notifyDataSetChanged()
    }

    fun insertNumber() {
        val numbers1 = Numbers(numbers.size + 1)
        numbers.add(numbers1)
        notifyItemInserted(numbers.size + 1)
    }

    fun removedNumber() {
        notifyItemRemoved(numbers.size)
    }

    override fun getItemCount() = numbers.size
}