package com.example.myapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.myapp.R
import com.example.myapp.data.AffairDatabase
import com.example.myapp.model.Affair
import com.example.myapp.viewmodel.AffairViewModel
import com.example.myapp.viewmodel.AffairViewModelFactory
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mAffairViewModelFactory: AffairViewModelFactory
    private lateinit var mAffairViewModel: AffairViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = AffairDatabase.getDatabase(application).affairDao()

        mAffairViewModelFactory = AffairViewModelFactory(dataSource, application)
        mAffairViewModel = ViewModelProviders.of(this, mAffairViewModelFactory).get(AffairViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val affair = addAffair_et.text.toString()
        val status = addStatus_et.text.toString()

        if(inputCheck(affair, status)){
            // Create User Object
            val affairL = Affair(
                0,
                affair,
                status
            )
            // Add Data to Database
            mAffairViewModel.addAffair(affairL)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(affair: String, status: String): Boolean{
        return !(TextUtils.isEmpty(affair) && TextUtils.isEmpty(status))
    }

}