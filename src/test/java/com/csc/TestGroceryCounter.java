package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter(0, 10000); // Initialize counter with starting value 0 and max value 10000
  }

  @Test
  void testTens() {
    counter.tens();
    assertEquals("$10.00", counter.total());
  }

  @Test
  void testOnes() {
    counter.ones();
    assertEquals("$1.00", counter.total());
  }

  @Test
  void testTenths() {
    counter.tenths();
    assertEquals("$0.10", counter.total());
  }

  @Test
  void testHundredths() {
    counter.hundredths();
    assertEquals("$0.01", counter.total());
  }

  @Test
  void testOverflow() {
    for (int i = 0; i < 100; i++) {
      counter.tens();  // Adds 1000 each time, causing an overflow after 10 iterations
    }
    assertEquals("$0.00", counter.total());
    assertEquals(10, counter.number_of_overflows()); // 10 overflows after 100 increments
  }

  @Test
  void testClear() {
    counter.tens();
    counter.clear();
    assertEquals("$0.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void testMultipleIncrements() {
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
