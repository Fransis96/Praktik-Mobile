// PhotoViewModel.kt
// File type -> Class



package com.example.internetimage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel() {
    private val repository = PhotosRepository(RetrofitClient.apiService)
    private val _photos = MutableStateFlow<List<MarsPhoto>>(emptyList())
    val photos: StateFlow<List<MarsPhoto>> get() = _photos
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error
    fun fetchPhotos() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = repository.fetchPhotos()
            result.onSuccess { data ->
                _photos.value = data
            }.onFailure {
                exception ->_error.value = exception.message
            }
            _loading.value = false
        }
    }
}