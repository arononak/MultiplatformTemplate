package com.example.multiplatformtemplate.data.local

import android.content.Context
import com.example.multiplatformtemplate.EmployeeDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

lateinit var appContext: Context

internal actual fun employeeDatabase(): EmployeeDatabase =
    EmployeeDatabase(AndroidSqliteDriver(EmployeeDatabase.Schema, appContext, "database.db"))