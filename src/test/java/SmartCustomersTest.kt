import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SmartCustomersTest {
  private fun testFindSmartCustomers(smartCustomers: Set<Int>, ec: ECommerce) {
    val message = "Wrong result for 'findSmartCustomers()'." + ec.display()
    val expected = smartCustomers.map { customer(it) }.toSet()
    Assertions.assertEquals(expected, ec.findSmartCustomers(), message)
  }

  @Test
  fun test0() = testFindSmartCustomers(emptySet(), ecommerce(0..2, 0..0))

  @Test
  fun test1() = testFindSmartCustomers(
    emptySet(),
    ecommerce(
      0..2, 0..2,
      listOf(
        Order(customer(0), listOf(OrderItem(product(1), 0.0)))
      )
    )
  )

  @Test
  fun test2() = testFindSmartCustomers(
    setOf(0),
    ecommerce(
      0..2, 0..2,
      listOf(
        Order(customer(0), listOf(OrderItem(product(1), 1.0)))
      )
    )
  )

  @Test
  fun test3() = testFindSmartCustomers(
    setOf(1),
    ecommerce(
      0..2, 0..2,
      listOf(
        Order(customer(0), listOf(OrderItem(product(1), 1.0))),
        Order(customer(0), listOf(OrderItem(product(1), 0.0))),
        Order(customer(1), listOf(OrderItem(product(1), 1.0)))
      )
    )
  )

  @Test
  fun test4() = testFindSmartCustomers(
    setOf(0, 1),
    ecommerce(
      0..2, 0..2,
      listOf(
        Order(
          customer(0), listOf(
            OrderItem(product(1), 1.0), OrderItem(product(2), 1.0)
          )
        ),
        Order(customer(0), listOf(OrderItem(product(1), 0.0))),
        Order(customer(1), listOf(OrderItem(product(1), 1.0)))
      )
    )
  )

}
