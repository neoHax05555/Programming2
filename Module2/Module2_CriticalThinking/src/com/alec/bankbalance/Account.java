package com.alec.bankbalance;

/**
 * POJO to represent account data. In this case we are only storing and manipulating the balance.
 */
public class Account {
    /**
     * Double to store the double value for users balance.
     */
    private double balance;

    /**
     * Initialize account to 0 if new.
     */
    Account() {
        this.balance = 0;
    }

    /**
     * Accumulates the amount into the current balance.
     *
     * @param amount The amount to deposit, must be a positive value.
     */
    public void depositFunds(double amount) {
        this.balance += amount;
    }

    /**
     * Decrements the balance by the amount passed in. If the balance is less than the amount we are trying to withdraw
     * will perform noop to prevent overdraft account.
     *
     * @param amount The dollar amount to try to remove from balance.
     *
     * @return true  - if sufficient funds were available.
     *         false - if insufficient funds available.
     */
    public boolean withdrawFunds(double amount) {
        boolean success = false;

        if (amount < this.balance) {
            this.balance -= amount;
            success = true;
        }

        return success;
    }

    /**
     * Getter method to return the balance.
     * @return The balance of this users acount.
     */
    public double getBalance() {
        return balance;
    }
}
