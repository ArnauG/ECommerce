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

}
