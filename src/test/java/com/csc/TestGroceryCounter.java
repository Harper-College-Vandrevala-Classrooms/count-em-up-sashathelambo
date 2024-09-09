package com.csc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
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
      counter.tens();
    }
    assertEquals("$0.00", counter.total());
    assertEquals(1, counter.number_of_overflows());
  }

  @Test
  void testClear() {
    counter.tens();
    counter.clear();
    assertEquals("$0.00", counter.total());
    assertEquals(0, counter.number_of_overflows());
  }

  @Test
  void itWorks() {
    assertEquals(true, true);
  }

}
