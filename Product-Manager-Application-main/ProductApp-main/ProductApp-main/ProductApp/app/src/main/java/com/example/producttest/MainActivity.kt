package com.example.producttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.producttest.navigation.NavGraph
import com.example.producttest.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ProductViewModel()

        setContent {
            NavGraph(viewModel)
        }
    }
}
