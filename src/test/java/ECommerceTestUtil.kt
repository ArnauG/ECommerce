fun product(i: Int) = Product("P-$i", 0.0)
fun product(indices: List<Int>): Set<Product> = indices.map(::product).toSet()
fun product(range: IntRange) = product(range.toList())

fun customer(i: Int) = Customer("C-$i")
fun customer(indices: List<Int>): Set<Customer> = indices.map(::customer).toSet()
fun customer(range: IntRange) = customer(range.toList())

fun ecommerce(costumer: IntRange, product: IntRange): ECommerce {
  return ECommerce(customer(costumer), product(product), ArrayList())
}

fun ecommerce(costumer: IntRange, product: IntRange, orders: List<Order>): ECommerce {
  return ECommerce(customer(costumer), product(product), orders)
}

fun order(customer: Int, product: IntRange) =
  Order(customer(customer), product(product).map { p -> OrderItem(p, 0.0) })

fun ECommerce.display() = buildString {
  appendLine()
  appendLine("ECommerce:")
  appendLine("Costumers: ${costumers.map { it.name }}")
  appendLine("Products: ${products.map { it.display() }}")
  appendLine("Orders: ${orders.map { it.display() }}")
}

fun Product.display() = buildString {
  return "($name, $price)"
}

fun Order.display() = buildString {
  return "(${customer.name}, ${orderItems.map { it.display() }})"
}

fun OrderItem.display() = buildString {
  return "${product.display()}, $discount"
}

