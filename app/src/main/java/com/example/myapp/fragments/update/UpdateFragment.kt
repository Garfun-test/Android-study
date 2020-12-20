package com.example.myapp.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapp.R
import com.example.myapp.data.AffairDatabase
import com.example.myapp.model.Affair
import com.example.myapp.viewmodel.AffairViewModel
import com.example.myapp.viewmodel.AffairViewModelFactory
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mAffairViewModelFactory: AffairViewModelFactory
    private lateinit var mAffairViewModel: AffairViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = AffairDatabase.getDatabase(application).affairDao()

        mAffairViewModelFactory = AffairViewModelFactory(dataSource, application)
        mAffairViewModel = ViewModelProviders.of(this, mAffairViewModelFactory).get(AffairViewModel::class.java)

        view.updateAffair_et.setText(args.currentAffair.affair)
        view.updateStatus_et.setText(args.currentAffair.status)

        view.update_btn.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val affair = updateAffair_et.text.toString()
        val status = updateStatus_et.text.toString()

        if (inputCheck(affair, status)) {
            // Create User Object
            val updatedAffair = Affair(args.currentAffair.id, affair, status)
            // Update Current User
            mAffairViewModel.updateAffair(updatedAffair)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(affair: String, status: String): Boolean {
        return !(TextUtils.isEmpty(affair) && TextUtils.isEmpty(status))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAffair()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAffair() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mAffairViewModel.deleteAffair(args.currentAffair)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentAffair.affair}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentAffair.affair}?")
        builder.setMessage("Are you sure you want to delete ${args.currentAffair.affair}?")
        builder.create().show()
    }
}