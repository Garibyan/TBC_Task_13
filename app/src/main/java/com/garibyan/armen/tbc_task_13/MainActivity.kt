package com.garibyan.armen.tbc_task_13

import android.os.Bundle
import android.util.Log.d
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.garibyan.armen.tbc_task_13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRetry.setOnClickListener {
            loadingViewState()
            viewModel.data()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.modelState.collect {
                when (it) {
                    is MainViewModel.ModelState.Success -> {
                        successViewState()
                        d("MODEL_STATE", "Success")
                        d("RESPONSE_MODEL_MAIN", it.model.toString())
                    }
                    is MainViewModel.ModelState.Error -> {
                        errorViewState()
                        d("MODEL_STATE", "Error")
                        d("MODELSTATE", it.error)

                    }
                    is MainViewModel.ModelState.Loading -> {
                        loadingViewState()
                        d("MODEL_STATE", "Loading")
                    }
                }
            }
        }
    }

    private fun successViewState() = with(binding){
        progressBar.visibility = View.GONE
        btnRetry.visibility = View.GONE
        tvResult.text = getString(R.string.success)
    }
    private fun errorViewState() = with(binding){
        progressBar.visibility = View.GONE
        btnRetry.visibility = View.VISIBLE
        tvResult.text = getString(R.string.error)
    }
    private fun loadingViewState() = with(binding){
        progressBar.visibility = View.VISIBLE
        btnRetry.visibility = View.GONE
        tvResult.text = getString(R.string.loading)
    }
}