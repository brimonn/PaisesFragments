package com.example.paisesfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListaPaisesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_lista_paises, container, false)

        val listaPaises = view.findViewById<ListView>(R.id.listaPaises)
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.paises,
            android.R.layout.simple_list_item_1
        )
        listaPaises.adapter = adapter

        return view
    }
}
