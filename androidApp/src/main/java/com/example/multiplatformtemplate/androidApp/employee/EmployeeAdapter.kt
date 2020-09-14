package com.example.multiplatformtemplate.androidApp.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplatformtemplate.androidApp.R
import com.example.multiplatformtemplate.androidApp.databinding.ItemListEmployeeBinding
import com.example.multiplatformtemplate.data.model.Employee

class EmployeeAdapter : ListAdapter<Employee, EmployeeAdapter.ViewHolder>(EmployeesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_employee, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemListEmployeeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Employee) = with(binding) {
            employee = item
        }
    }
}

private class EmployeesDiffCallback : DiffUtil.ItemCallback<Employee>() {

    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean = oldItem.id == newItem.id
}