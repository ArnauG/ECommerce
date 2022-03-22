import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FrequentProductsTest {
  private fun testFindFrequentProducts(frequentProducts: Set<Int>, customer: Int, ec: ECommerce) {
    val message = "Wrong result for 'findEagerCustomers()'." + ec.display()
    val expected = frequentProducts.map { product(it) }.toSet()
    Assertions.assertEquals(expected, ec.findFrequentProducts(customer(customer)), message)
  }

  @Test
  fun test0() = testFindFrequentProducts(emptySet(), 1, ecommerce(0..2, 0..0))

  @Test
  fun test1() = testFindFrequentProducts(
    emptySet(),
    1,
    ecommerce(
      0..2,
      0..1,
      listOf(
        order(1,0 .. 0)
      )
    ))

  @Test
  fun test2() = testFindFrequentProducts(
    setOf(1),
    1,
    ecommerce(
      0..2,
      0..1,
      listOf(
        order(1,1 .. 1),
        order(1,1 .. 1)
      )
    ))

  @Test
  fun test3() = testFindFrequentProducts(
    setOf(1,3),
    1,
    ecommerce(
      0..2,
      0..3,
      listOf(
        order(1,0 .. 3),
        order(1,1 .. 1),
        order(1,3 .. 3),
      )
    ))
}
