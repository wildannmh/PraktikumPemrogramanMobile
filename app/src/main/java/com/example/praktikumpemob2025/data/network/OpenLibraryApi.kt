package com.example.praktikumpemob2025.data.network

import com.example.praktikumpemob2025.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {
    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit: Int
    ): Response<SearchResponse>
}