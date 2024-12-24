// PhotosRepository.kt
// File type -> Class


package com.example.internetimage

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosRepository(private val apiService: ApiService) {
    suspend fun fetchPhotos(): Result<List<MarsPhoto>> {
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService.getPhotos()
            }
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}