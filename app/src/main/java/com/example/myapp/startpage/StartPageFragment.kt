package com.example.myapp.startpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.R
import com.example.myapp.addaffairs.AddAffairsFragment
import com.example.myapp.addaffairs.AddAffairsViewModel
import com.example.myapp.addaffairs.AddAffairsViewModelFactory
import com.example.myapp.startpage.StartPageFragment
import com.example.myapp.startpage.StartPageViewModel
import com.example.myapp.startpage.StartPageViewModelFactory
import com.example.myapp.databinding.FragmentStartPageBinding

class StartPageFragment : Fragment() {

    private lateinit var binding: FragmentStartPageBinding
    private lateinit var viewModel: StartPageViewModel
    private lateinit var viewModelFactory: StartPageViewModelFactory

    val LOG_TAG = "StartPage"

    //FragmentManager transaction  = getSupportFragmentManager().beginTransaction();
    //var addlist: Fragment = AddAffairsFragment()

    /*@Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(LOG_TAG,"Destroyed");
    }*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_start_page, container, false)

        //container = (FrameLayout) view.findViewById(R.id.container);
        //val buttonEnter = view.findViewById<View>(R.id.button) as Button
        //Button buttonDev = (Button) view.findViewById(R.id.button2);
       // val editText = view.findViewById<View>(R.id.edit_message) as EditText

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_start_page,
                container,
                false
        )

        viewModelFactory = StartPageViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StartPageViewModel::class.java)

        binding.startPageViewModel = viewModel
        binding.setLifecycleOwner(this)



        binding.button.setOnClickListener { v ->
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            //fragmentTransaction.replace(R.id.fragment_start_page, addlist);
            //fragmentTransaction.add(R.id.fragment_start_page, new AddAffairsFragment()).commit();
            fragmentTransaction.replace(R.id.activity_main, AddAffairsFragment()).commit()

            //onDestroyView();
            //fragmentTransaction.show(StartPageFragment.this).commit();

            //.commit();
            //fragmentTransaction.commit();
            val toast = Toast.makeText(v.context, "Хеллоу ", Toast.LENGTH_SHORT)
            toast.show()

            //transaction.replace(R.layout.fragment_start_page, new AddAffairsFragment()).commit();
        }
        return binding.root
    }
}