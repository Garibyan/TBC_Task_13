package com.garibyan.armen.tbc_task_13

import com.garibyan.armen.tbc_task_13.network.ApiService
import com.garibyan.armen.tbc_task_13.network.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val apiService: ApiService) {

    suspend fun getData(): Flow<Model>{
        return flow {
            val model = apiService.getData()
            emit(model)
        }.flowOn(Dispatchers.IO)
    }

}