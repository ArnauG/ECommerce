import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SmartCustomersTest{
  private fun testFindSmartCustomers(smartCustomers: Set<Int>,  ec: ECommerce) {
    val message = "Wrong result for 'findSmartCustomers()'." + ec.display()
    val expected = smartCustomers.map { customer(it) }.toSet()
    Assertions.assertEquals(expected, ec.findSmartCustomers(), message)
  }

  @Test
  fun test0() = testFindSmartCustomers(emptySet(),  ecommerce(0..2, 0..0))

}
