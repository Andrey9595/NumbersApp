package ru.anb.numbers


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.anb.numbers.MainFragment.Companion.KEY



class OwnNumberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_own_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Numbers>(KEY)?.let {
            val textV: TextView = view.findViewById(R.id.thed_text)
            textV.text = it.number.toString()
            textV.setTextColor(it.color)
        }
    }


    companion object {
        fun newInstance(bundle: Bundle?) = OwnNumberFragment().apply {
            arguments = bundle
        }
    }
}