package com.example.multiplatformtemplate.data.repository

import com.example.multiplatformtemplate.data.local.DatabaseEmployeeDao
import com.example.multiplatformtemplate.data.model.DataResult
import com.example.multiplatformtemplate.data.model.Employee
import com.example.multiplatformtemplate.data.remote.EmployeesApiService

class EmployeesRepository {

    suspend fun fetchEmployees(): DataResult<List<Employee>> = try {
        val employees = EmployeesApiService.INSTANCE.fetchEmployees()
        DatabaseEmployeeDao.INSTANCE.updateEmployees(employees)
        DataResult.Success(employees)
    } catch (e: Exception) {
        val employees = DatabaseEmployeeDao.INSTANCE.fetchEmployees()

        when (employees.isEmpty()) {
            true -> DataResult.Error(e)
            else -> DataResult.Success(employees)
        }
    }

    companion object {
        var INSTANCE = EmployeesRepository()
    }
}