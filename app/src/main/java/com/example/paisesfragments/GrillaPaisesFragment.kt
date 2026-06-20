package com.example.paisesfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment

class GrillaPaisesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_grilla_paises, container, false)

        val grillaPaises = view.findViewById<GridView>(R.id.grillaPaises)
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.paises,
            android.R.layout.simple_list_item_1
        )
        grillaPaises.adapter = adapter

        return view
    }
}
