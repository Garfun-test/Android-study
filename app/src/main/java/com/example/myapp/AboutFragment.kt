package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val buttonDev = view.findViewById<View>(R.id.button) as Button

        // Inflate the layout for this fragment
        buttonDev.setOnClickListener { v ->
            val toast = Toast.makeText(v.context, "Розроблена Бережанським Дмитром", Toast.LENGTH_LONG)
            toast.show()
        }
        return view
    }
}