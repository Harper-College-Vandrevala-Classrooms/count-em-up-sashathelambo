package com.csc;

public class GroceryCounter {
  private int counter;
  private int overflows;

  public GroceryCounter() {
    this.counter = 0;
    this.overflows = 0;
  }

  public void tens() {
    this.counter += 1000;
    checkOverflow();
  }

  public void ones() {
    this.counter += 100;
    checkOverflow();
  }

  public void tenths() {
    this.counter += 10;
    checkOverflow();
  }

  public void hundredths() {
    this.counter += 1;
    checkOverflow();
  }

  private void checkOverflow() {
    if (this.counter >= 10000) {
      this.counter -= 10000;
      this.overflows++;
    }
  }

  public String total() {
    int dollars = this.counter / 100;
    int cents = this.counter % 100;
    return String.format("$%d.%02d", dollars, cents);
  }

  public int number_of_overflows() {
    return this.overflows;
  }

  public void clear() {
    this.counter = 0;
    this.overflows = 0;
  }
}
