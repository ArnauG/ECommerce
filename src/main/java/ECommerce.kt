data class ECommerce(
  val costumers: Set<Customer>,
  val products: Set<Product>,
  val orders: List<Order>
)

data class Customer(val name: String)
data class Product(val name: String, val price: Double)
data class OrderItem(val product: Product, val discount: Double) {
  fun cost(): Double = product.price - discount
}

data class Order(val customer: Customer, val orderItems: List<OrderItem>)

fun ECommerce.notOrderedProducts(): Set<Product> {
  return this.products - orders.flatMap { order ->
    order.orderItems.map { orderItem -> orderItem.product }
  }.toSet()
}

fun ECommerce.findEagerCustomers(eagerThreshold: Int): Set<Customer> {
  return this.orders
    .flatMap { order -> order.orderItems.map { order.customer } }
    .groupBy { customer -> customer }
    .filterValues { group -> group.size > eagerThreshold }
    .keys
}

fun ECommerce.findFrequentProducts(customer: Customer): Set<Product> {
  val customerOrderedItems = this.orders.filter { order -> order.customer == customer }
    .flatMap { order -> order.orderItems }
  return this.products.filter { p -> customerOrderedItems.count { co -> p == co.product } > 1 }.toSet()
}

fun ECommerce.findSmartCustomers(): Set<Customer> {
  return emptySet()
}

