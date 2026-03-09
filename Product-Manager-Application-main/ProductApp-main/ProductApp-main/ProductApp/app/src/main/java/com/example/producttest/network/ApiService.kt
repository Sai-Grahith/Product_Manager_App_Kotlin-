package com.example.producttest.network

import com.example.producttest.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts():List<Product>
}
