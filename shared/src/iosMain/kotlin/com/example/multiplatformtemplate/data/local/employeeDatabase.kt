package com.example.multiplatformtemplate.data.local

import com.example.multiplatformtemplate.EmployeeDatabase

internal actual fun employeeDatabase(): EmployeeDatabase =
    EmployeeDatabase(NativeSqliteDriver(EmployeeDatabase.Schema, appContext, "database.db"))
