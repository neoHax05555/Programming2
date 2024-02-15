package com.alec.banking;

public class Main {
    public static void main(String[] args) {
        CheckingAccount myAccount = new CheckingAccount();
        myAccount.setAccountID(1);
        myAccount.setFirstName("Jim");
        myAccount.setLastName("Smith");
        myAccount.setInterestRate(.05);

        // Lets make an initial deposit of $200.
        myAccount.deposit(200);
        myAccount.accountSummary();

        // Now lets withdraw $100.
        myAccount.withdrawal(100);
        myAccount.accountSummary();

        //now lets overdraft by $5, should result in -$35 since $30 average fee.
        myAccount.withdrawal(105);
        myAccount.accountSummary();
    }
}
