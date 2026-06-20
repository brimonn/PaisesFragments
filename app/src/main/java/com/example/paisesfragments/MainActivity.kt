package com.example.paisesfragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<AppCompatSpinner>(R.id.spinnerModo)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modo,
            android.R.layout.simple_spinner_item
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        if (savedInstanceState == null) {
            cargarFragmento(ListaPaisesFragment())
        }

        var primeraSeleccion = true
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (primeraSeleccion) {
                    primeraSeleccion = false
                    return
                }

                val fragment: Fragment = when (position) {
                    0 -> ListaPaisesFragment()
                    else -> GrillaPaisesFragment()
                }
                cargarFragmento(fragment)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }
    }

    private fun cargarFragmento(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, fragment)
        }
    }
}
