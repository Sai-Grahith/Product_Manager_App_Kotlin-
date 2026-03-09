@Composable
fun AddProductScreen(navController: NavController, viewModel: ProductViewModel) {

    var title by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))   // changed background
            .padding(16.dp)
    ) {

        Text(
            text = "Add Product",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2962FF)   // blue title
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF2962FF),
                focusedLabelColor = Color(0xFF2962FF)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF2962FF),
                focusedLabelColor = Color(0xFF2962FF)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF2962FF),
                focusedLabelColor = Color(0xFF2962FF)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (title.isNotEmpty() && price.isNotEmpty()) {

                    viewModel.addProduct(
                        Product(
                            id = viewModel.productList.size + 1,
                            title = title,
                            price = price.toDouble(),
                            description = description,
                            image = ""
                        )
                    )

                    navController.popBackStack()

                }

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2962FF),  // blue button
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Save")

        }

    }

}