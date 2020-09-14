package com.example.multiplatformtemplate.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Employee(
    @SerialName("id")
    val id: String,

    @SerialName("employee_name")
    val employeeName: String,

    @SerialName("employee_salary")
    val employeeSalary: String,

    @SerialName("employee_age")
    val employeeAge: String,

    @SerialName("profile_image")
    val profileImage: String
)
