package com.example.producttest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.producttest.ui.screens.*
import com.example.producttest.viewmodel.ProductViewModel

@Composable
fun NavGraph(viewModel:ProductViewModel){

    val navController = rememberNavController()

    NavHost(navController,startDestination="list"){

        composable("list"){
            ProductListScreen(navController,viewModel)
        }

        composable("add"){
            AddProductScreen(navController,viewModel)
        }

        composable("detail/{title}/{price}/{description}"){

            ProductDetailScreen(
                title = it.arguments?.getString("title") ?: "",
                price = it.arguments?.getString("price") ?: "",
                description = it.arguments?.getString("description") ?: ""
            )
        }
    }
}
