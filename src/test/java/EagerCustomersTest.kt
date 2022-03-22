import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EagerCustomersTest {

  private fun testFindEagerCustomers(eagerCustomers: Set<Int>, eagerThreshold: Int, ec: ECommerce) {
    val message = "Wrong result for 'findEagerCustomers()'." + ec.display()
    val expected = eagerCustomers.map { customer(it) }.toSet()
    Assertions.assertEquals(expected, ec.findEagerCustomers(eagerThreshold), message)
  }

  @Test
  fun test1() = testFindEagerCustomers(emptySet(), 1, ecommerce(1..2, 1..2))

  @Test
  fun test2() = testFindEagerCustomers(
    setOf(1),
    0,
    ecommerce(
      1..2,
      1..2,
      listOf(
        order(1, 1..1),
      )
    )
  )

  @Test
  fun test3() = testFindEagerCustomers(
    setOf(1),
    1,
    ecommerce(
      1..3,
      1..2,
      listOf(
        order(1, 1..2),
        order(2, 1..1),
      )
    )
  )

  @Test
  fun test4() = testFindEagerCustomers(
    setOf(1,3),
    1,
    ecommerce(
      1..3,
      1..2,
      listOf(
        order(1, 1..2),
        order(2, 1..1),
        order(3, 1..5),
      )
    )
  )

}
