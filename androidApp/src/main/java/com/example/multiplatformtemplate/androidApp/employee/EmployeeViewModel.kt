package com.example.multiplatformtemplate.androidApp.employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multiplatformtemplate.data.model.DataResult
import com.example.multiplatformtemplate.data.model.Employee
import com.example.multiplatformtemplate.data.repository.EmployeesRepository
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {

    val employees = MutableLiveData<List<Employee>>(emptyList())

    init {
        loadList()
    }

    private fun loadList() {
        viewModelScope.launch {
            when (val result = EmployeesRepository.INSTANCE.fetchEmployees()) {
                is DataResult.Success -> {
                    employees.postValue(result.data)
                }
                is DataResult.Error -> {
                    employees.postValue(emptyList())
                }
            }
        }
    }
}