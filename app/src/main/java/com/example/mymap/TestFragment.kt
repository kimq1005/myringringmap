package com.example.mymap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.mymap.adapter.TestAdapter
import com.example.mymap.databinding.FragmentTestBinding


class TestFragment : Fragment() {

//    lateinit var testAdapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTestBinding.inflate(inflater , container , false)





        return binding.root
//        return inflater.inflate(R.layout.fragment_test, container, false)
    }





}