package com.example.myapp.addaffairs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.R
import com.example.myapp.databinding.FragmentAddAffairsBinding
import com.example.myapp.todolist.ToDoListFragment
import kotlinx.android.synthetic.main.fragment_add_affairs.*
import java.util.*

class AddAffairsFragment : Fragment() {

    private lateinit var binding: FragmentAddAffairsBinding
    private lateinit var viewModel: AddAffairsViewModel
    private lateinit var viewModelFactory: AddAffairsViewModelFactory

    var todolist: Fragment = ToDoListFragment()
    //var list = ArrayList<String>()
    //var index = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_add_affairs,
                container,
                false
        )

        viewModelFactory = AddAffairsViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddAffairsViewModel::class.java)

        binding.addAffairsViewModel = viewModel
        binding.setLifecycleOwner(this)

        //val view = inflater.inflate(R.layout.fragment_add_affairs, container, false)
        //val buttonAdd = view?.findViewById<View>(R.id.button1) as Button
        //val buttonNext = view?.findViewById<View>(R.id.button2) as Button
        //val editText = view.findViewById<View>(R.id.editView) as EditText
        binding.button1.setOnClickListener { v ->
            viewModel.Add(v)
            }

        binding.button2.setOnClickListener {
            //val bundle = Bundle()
            //bundle.putStringArrayList(KEY, list)
            //todolist.arguments = bundle
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            //fragmentTransaction.replace(R.id.fragment_start_page, addlist);
            //fragmentTransaction.add(R.id.fragment_start_page, new AddAffairsFragment()).commit();
            fragmentTransaction.replace(R.id.activity_main, ToDoListFragment()).commit()

            //onDestroyView();
            //fragmentTransaction.show(StartPageFragment.this).commit();

            //.commit();
            //fragmentTransaction.commit();
        }
        return binding.root
    }

    companion object {
        const val KEY = "key"
    }
}