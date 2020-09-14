package com.example.multiplatformtemplate.androidApp.employee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplatformtemplate.androidApp.R

class MainActivity : AppCompatActivity() {

    private val viewModel: EmployeeViewModel by viewModels()
    private val adapter = EmployeeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter
        viewModel.employees.observe(this) { adapter.submitList(it) }
    }
}
