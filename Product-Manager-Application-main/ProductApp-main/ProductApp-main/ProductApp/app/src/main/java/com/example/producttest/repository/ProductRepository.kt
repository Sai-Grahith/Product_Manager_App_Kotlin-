package com.example.producttest.repository

import com.example.producttest.network.RetrofitInstance

class ProductRepository {

    suspend fun getProducts() =
        RetrofitInstance.api.getProducts()
}
