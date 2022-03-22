import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NotOrderedProductsTest{
  private fun testNotOrderedProducts(notOrderedProductsIndexes: Set<Int>, ec: ECommerce) {
    val message = "Wrong result for 'notOrderedProducts()'." + ec.display()
    val expected = notOrderedProductsIndexes.map { product(it) }.toSet()
    assertEquals(expected, ec.notOrderedProducts(), message)
  }

  @Test
  fun test0() = testNotOrderedProducts(setOf(0), ecommerce(0..2, 0..0))

  @Test
  fun test1() = testNotOrderedProducts(setOf(0,1,2), ecommerce(0..2, 0..2))

  @Test
  fun test2() = testNotOrderedProducts(
    setOf(1),
    ecommerce(0..2, 0..1, listOf(order(1,0 .. 0))
  ))

  @Test
  fun test3() = testNotOrderedProducts(
    emptySet(),
    ecommerce(0..2,
      0..1,
      listOf(
        order(1,0 .. 0),
        order(1,0 .. 1)
      )
    ))

  @Test
  fun test4() = testNotOrderedProducts(
    emptySet(),
    ecommerce(0..2,
      0..1,
      listOf(
        order(1,0 .. 0),
        order(2,0 .. 1)
      )
    ))

  @Test
  fun test5() = testNotOrderedProducts(
    setOf(2),
    ecommerce(0..2,
      0..2,
      listOf(
        order(1,0 .. 0),
        order(2,0 .. 1)
      )
    ))
}
