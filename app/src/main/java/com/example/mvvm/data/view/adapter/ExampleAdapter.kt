package com.example.mvvm.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.data.model.ExampleModel
import com.example.mvvm.databinding.ExampleAdapterBinding

class ExampleAdapter(
    var example: ArrayList<ExampleModel>,
    var listener: OnAdapterListener
) : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {


    interface OnAdapterListener {
        fun onClick(result: ArrayList<ExampleModel>)
    }

    class ViewHolder(val binding: ExampleAdapterBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val examples = example[position]
        holder.binding.container.setOnClickListener {

        }
    }

    override fun getItemCount() = example.size

    fun setData(data: List<ExampleModel>) {
        example.clear()
        example.addAll(data)
        notifyDataSetChanged()
    }

}