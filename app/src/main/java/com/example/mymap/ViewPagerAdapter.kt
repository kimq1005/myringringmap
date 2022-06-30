package com.example.mymap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mymap.databinding.ItemViewpagerBinding
import com.example.mymap.model.library.Row

class ViewPagerAdapter:ListAdapter<Row,ViewPagerAdapter.PagerViewHolder>(differ) {



    inner class PagerViewHolder(val binding: ItemViewpagerBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(row: Row){
            binding.storeName.text = row.LBRRY_NAME
            binding.anydata.text = row.TEL_NO

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
       holder.bind(currentList[position])
    }


    companion object {

        val differ = object : DiffUtil.ItemCallback<Row>() {
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.CODE_VALUE == newItem.CODE_VALUE
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem == newItem
            }

        }
    }


}