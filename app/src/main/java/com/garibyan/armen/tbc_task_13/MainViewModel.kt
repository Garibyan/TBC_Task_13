package com.garibyan.armen.tbc_task_13

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garibyan.armen.tbc_task_13.network.ApiClient
import com.garibyan.armen.tbc_task_13.network.Model
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
    = Repository(ApiClient.apiService)
) : ViewModel() {

    private val _modelState = MutableStateFlow<ModelState>(ModelState.Loading)
    val modelState: StateFlow<ModelState> = _modelState

    sealed class ModelState {
        data class Success(val model: Model) : ModelState()
        data class Error(val error: String) : ModelState()
        object Loading : ModelState()
    }

    init {
        data()
    }

    fun data() = viewModelScope.launch {
        _modelState.value = ModelState.Loading
        try {
            repository.getData().collect {
                _modelState.value = ModelState.Success(it)
                d("RESPONSE_MODEL", it.toString())
            }
        } catch (e: Exception) {
            _modelState.value = ModelState.Error(e.toString())
        }
    }

}