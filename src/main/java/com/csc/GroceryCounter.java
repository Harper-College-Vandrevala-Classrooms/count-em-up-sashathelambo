package com.csc;

public class GroceryCounter {
    private int counter;
    private int overflows;

    public GroceryCounter() {
        this.counter = 0;
        this.overflows = 0;
    }

    // Adds 10 dollars (or 1000 cents)
    public void tens() {
        this.counter += 1000;
        checkOverflow();
    }

    // Adds 1 dollar (or 100 cents)
    public void ones() {
        this.counter += 100;
        checkOverflow();
    }

    // Adds 10 cents
    public void tenths() {
        this.counter += 10;
        checkOverflow();
    }

    // Adds 1 cent
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

    // Formats the total value as a dollar amount
    public String total() {
        int dollars = this.counter / 100;
        int cents = this.counter % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    // Returns the number of overflows
    public int number_of_overflows() {
        return this.overflows;
    }

    // Clears the counter and overflow count
    public void clear() {
        this.counter = 0;
        this.overflows = 0;
    }

    public static void main(String[] args) {
        System.exit(1);
    }
}
