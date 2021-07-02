package com.example.mvvm.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.data.model.ExampleModel
import com.example.mvvm.databinding.ExampleAdapterBinding
import java.util.*
import kotlin.collections.ArrayList

class ExampleAdapterWithFilter(
    var example: ArrayList<ExampleModel>,
    var listener: OnAdapterListener
) : RecyclerView.Adapter<ExampleAdapterWithFilter.ViewHolder>(), Filterable {

    private var exampleFilter = ArrayList<ExampleModel>()

    init {
        exampleFilter = example
    }


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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val char = constraint.toString()
                if (char.isEmpty()) {
                    exampleFilter = example
                } else {
                    val exampleFiltered = ArrayList<ExampleModel>()
                    for (example in example) {
                        if (example.exampleString.lowercase(Locale.getDefault())
                                .contains(char.lowercase(Locale.getDefault()))
                        ) {
                            exampleFiltered.add(example)
                        }
                    }
                    exampleFilter = exampleFiltered
                }
                val exampleResult = FilterResults()
                exampleResult.values = exampleFilter
                return exampleResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                exampleFilter = results?.values as ArrayList<ExampleModel>
                notifyDataSetChanged()
            }
        }
    }
}