package com.alec.banking;

public class CheckingAccount extends BankAccount {
    private static final int OVER_DRAFT_FEE = 30;
    double interestRate;

    CheckingAccount() {
        super();
        interestRate = 0;
    }

    @Override
    public void withdrawal(double dollarAmount) {
        // If the resulting balance is an overdraft, add fee to amount.
        if ((super.getBalance() - dollarAmount) < 0) {
            System.out.println("Overdraft detected... Charging additional $" + OVER_DRAFT_FEE);
            dollarAmount += OVER_DRAFT_FEE;
        }
        super.withdrawal(dollarAmount);
    }

    @Override
    public void accountSummary() {
        super.accountSummary();
        System.out.printf("%-10s %f\n", "Interest Rate:", this.interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
