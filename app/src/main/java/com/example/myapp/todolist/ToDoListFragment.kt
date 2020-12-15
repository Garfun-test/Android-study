package com.example.myapp.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.R
import com.example.myapp.databinding.FragmentStartPageBinding
import com.example.myapp.startpage.StartPageViewModelFactory
import com.example.myapp.todolist.ToDoListViewModel
import com.example.myapp.todolist.ToDoListViewModelFactory
import java.util.*
import com.example.myapp.databinding.FragmentToDoListBinding
import com.example.myapp.startpage.StartPageViewModel

class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding
    private lateinit var viewModel: ToDoListViewModel
    private lateinit var viewModelFactory: ToDoListViewModelFactory

    var msg: ArrayList<String>? = ArrayList()
    lateinit var textViews: Array<TextView>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_to_do_list,
                container,
                false
        )

        viewModelFactory = ToDoListViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ToDoListViewModel::class.java)

        binding.toDoListViewModel = viewModel
        binding.setLifecycleOwner(this)

        //val view = inflater.inflate(R.layout.fragment_to_do_list, container, false)
        //val bundle = arguments
        //msg = bundle!!.getStringArrayList(KEY)
        //val textview1 = view.findViewById<View>(R.id.textView) as TextView
        //val textview2 = view.findViewById<View>(R.id.textView2) as TextView
        //val textview3 = view.findViewById<View>(R.id.textView3) as TextView
        //textViews = arrayOf(
        //        textview1,
         //       textview2,
           //     textview3
        //)
        val index = msg!!.size
        if (index != 0) {
            for (i in 0 until index) {
                //help[i] = textmes.get(i);
                textViews[i].text = (i + 1).toString() + ": " + msg!![i]
            }
        }
        return binding.root
    }

    companion object {
        const val KEY = "key"
    }
}