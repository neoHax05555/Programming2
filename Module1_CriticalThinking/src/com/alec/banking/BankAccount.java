package com.alec.banking;

public class BankAccount {
    String firstName;
    String lastName;
    int accountID;
    double balance;

    /**
     * initialize balance to zero.
     */
    BankAccount() {
        this.balance = 0;
        this.firstName = "";
        this.lastName = "";
        this.accountID = -1;
    }

    /**
     * The parameter value is added to the existing balance.
     *
     * @param dollarAmount Dollar amount to add to this users account.
     */
    public void deposit(double dollarAmount) {
        if (dollarAmount < 0) {
            System.out.println("Please enter a positive dollar amount.");
        } else {
            this.balance += dollarAmount;
            System.out.println("After deposit of: $" + dollarAmount + " Your balance is now: $" + this.balance);
        }
    }

    /**
     * The parameter value is subtracted from the existing balance.
     *
     * @param dollarAmount Dollar amount to add to this users account.
     */
    public void withdrawal(double dollarAmount) {
        if (dollarAmount < 0) {
            System.out.println("Please enter a positive dollar amount.");
        } else {
            this.balance -= dollarAmount;
            System.out.println("After withdrawing: $" + dollarAmount + " Your balance is now: $" + this.balance);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Prints a summary of this account.
     */
    public void accountSummary() {
        System.out.printf("%-10s %d\n", "Account#:", this.accountID);
        System.out.printf("%-10s %s %s\n", "Name:", this.firstName, this.lastName);
        System.out.printf("%-10s $%f\n", "Balance:", this.balance);
    }
}
