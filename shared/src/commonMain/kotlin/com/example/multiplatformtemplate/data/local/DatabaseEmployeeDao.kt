package com.example.multiplatformtemplate.data.local

import com.example.multiplatformtemplate.EmployeeDatabase
import com.example.multiplatformtemplate.data.model.Employee
import com.example.multiplatformtemplate.database.EmployeeDb

class DatabaseEmployeeDao(private val database: EmployeeDatabase) {

    fun fetchEmployees(): List<Employee> = database.employeeQueries.selectAll().executeAsList().map(EmployeeDb::toEmployee)

    fun insertEmployee(employee: Employee) = database.employeeQueries
        .insertItem(employee.id, employee.employeeName, employee.employeeSalary, employee.employeeAge, employee.profileImage)

    fun insertEmployees(employees: List<Employee>): Unit = employees.forEach(this@DatabaseEmployeeDao::insertEmployee)

    fun clearEmployees(): Unit = database.employeeQueries.deleteAll()

    fun updateEmployees(employees: List<Employee>) {
        clearEmployees()
        insertEmployees(employees)
    }

    companion object {
        var INSTANCE = DatabaseEmployeeDao(employeeDatabase())
    }
}

private fun EmployeeDb.toEmployee() =
    Employee(
        id = id,
        employeeName = employee_name,
        employeeSalary = employee_salary,
        employeeAge = employee_age,
        profileImage = profile_image
    )