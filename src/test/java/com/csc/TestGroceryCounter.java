package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  @Test
  void testTens() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    counter.tens();
    assertEquals("$10.00", counter.total());
  }

  @Test
  void testOnes() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    counter.ones();
    assertEquals("$1.00", counter.total());
  }

  @Test
  void testTenths() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    counter.tenths();
    assertEquals("$0.10", counter.total());
  }

  @Test
  void testHundredths() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    counter.hundredths();
    assertEquals("$0.01", counter.total());
  }

  @Test
  void testOverflow() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    for (int i = 0; i < 100; i++) {
      counter.tens();  // Adds 1000 each time, causing an overflow after 10 iterations
    }
    assertEquals("$0.00", counter.total());
    assertEquals(10, counter.number_of_overflows()); // 10 overflows after 100 increments
  }

  @Test
  void testClear() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    counter.tens();
    counter.clear();
    assertEquals("$0.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void testMultipleIncrements() {
    GroceryCounter counter = new GroceryCounter(0, 10000);
    counter.tens();   // Adds $10.00
    counter.ones();    // Adds $1.00
    counter.tenths();  // Adds $0.10
    counter.hundredths(); // Adds $0.01

    assertEquals("$11.11", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void itWorks() {
    assertTrue(true);
  }
}
