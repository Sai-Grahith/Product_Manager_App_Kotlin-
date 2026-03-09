package com.example.producttest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable

fun ProductDetailScreen(title: String, price: String, description: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA)) // background color
            .padding(16.dp)
    ) {

        Text(
            text = "Product Details",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2962FF) // title blue
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White // card color
            ),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text("Title", color = Color.Gray)
                Text(title, color = Color(0xFF212121)) // dark text

                Spacer(modifier = Modifier.height(16.dp))

                Text("Price", color = Color.Gray)
                Text(
                    text = "₹ $price",
                    color = Color(0xFF0D47A1) // price blue
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Description", color = Color.Gray)
                Text(description, color = Color(0xFF212121))

            }

        }

    }

}