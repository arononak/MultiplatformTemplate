package com.example.multiplatformtemplate.data.remote

import com.example.multiplatformtemplate.data.model.Employee
import com.example.multiplatformtemplate.data.model.Response
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class EmployeesApiService {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        Logging {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
        defaultRequest {
            url {
                host = "dummy.restapiexample.com"
                port = 80
                protocol = URLProtocol.HTTP
            }
        }
    }

    suspend fun fetchEmployees(): List<Employee> = client.get<Response<List<Employee>>>("/api/v1/employees").data

    companion object {
        var INSTANCE = EmployeesApiService()
    }
}
