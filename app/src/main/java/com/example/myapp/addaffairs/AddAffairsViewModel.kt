package com.example.myapp.addaffairs

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapp.R

class AddAffairsViewModel : ViewModel() {

    private val _affairs = MutableLiveData<String>()
    val affairs : LiveData<String>
        get() = _affairs

    init {
        //_affairs.value = ""
    }

    //private val _list = MutableLiveData<String>()
    val list : LiveData<ArrayList<String>>
        get() = list

    private val _index = MutableLiveData<String>()
    val index : LiveData<String>
        get() = _index

    fun Add(v: View) {
        //if (_affairs.value.toString().length >= 6) {
          //  list.value?.add(_affairs.value.toString())
           // _index.value+1
            //_affairs.value = ""
           // val toast = Toast.makeText(v.context, "Справу додано успішно", Toast.LENGTH_SHORT)
           // toast.show()
       // } else {
            //val toast = Toast.makeText(v.context, "Більше 6 символів", Toast.LENGTH_SHORT)
            //val toast = Toast.makeText(v.context, _affairs.value.toString(), Toast.LENGTH_SHORT)
            //toast.show()
        //}
        //if (index >= 3) {
        //    buttonAdd.isEnabled = false
        //    editText.isEnabled = false
        //}
    }

    /*fun GoNext(v: View){
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        //fragmentTransaction.replace(R.id.fragment_start_page, addlist);
        //fragmentTransaction.add(R.id.fragment_start_page, new AddAffairsFragment()).commit();
        fragmentTransaction.replace(R.id.activity_main, AddAffairsFragment()).commit()
    }*/


}