package com.example.mymap.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymap.databinding.ItemLibraryBinding
import com.example.mymap.model.library.Row

class TestAdapter:ListAdapter<Row, TestAdapter.TestViewHolder>(differ) {

    lateinit var library: List<Row>

    class TestViewHolder(val binding: ItemLibraryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(library: Row){
            binding.storeName.text = library.LBRRY_NAME
            binding.anydata.text = library.TEL_NO
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return TestViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(library[position])
    }

    companion object {
        val differ = object :DiffUtil.ItemCallback<Row>(){
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.CODE_VALUE == newItem.CODE_VALUE
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem == newItem
            }

        }
    }





}