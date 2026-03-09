@Composable
fun ProductListScreen(navController: NavController, viewModel: ProductViewModel) {

    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))   // changed background
            .padding(16.dp)
    ) {

        Text(
            text = "Products",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2962FF)  // primary blue
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("add") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2962FF), // button blue
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Product")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(viewModel.productList) { product ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate(
                                "detail/${product.title}/${product.price}/${product.description}"
                            )
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White // card white
                    ),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = product.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF212121) // dark text
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "₹ ${product.price}",
                            color = Color(0xFF0D47A1) // price blue
                        )

                    }

                }

            }

        }

    }

}