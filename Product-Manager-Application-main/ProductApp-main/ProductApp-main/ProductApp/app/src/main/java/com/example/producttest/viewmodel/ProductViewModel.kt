package com.example.producttest.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producttest.model.Product
import com.example.producttest.network.RetrofitInstance
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    var productList = mutableStateListOf<Product>()
        private set

    fun fetchProducts() {

        // Prevent reloading API if products already exist
        if (productList.isNotEmpty()) return

        viewModelScope.launch {

            try {

                val products = RetrofitInstance.api.getProducts()

                productList.addAll(products)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    fun addProduct(product: Product) {
        productList.add(product)
    }

}