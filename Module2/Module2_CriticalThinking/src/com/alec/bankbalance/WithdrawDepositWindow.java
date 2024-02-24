package com.alec.bankbalance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Produces a window that allows user to withdraw or deposit ot their account.
 */
public class WithdrawDepositWindow extends GenericWindow {
    /*
     * Member variables begin.
     */
    /**
     * Account object which should have users balance initialized.
     */
    private final Account account;
    /**
     * Additional JButton to invoke a withdrawal.
     */
    private final JButton jButton;

    /**
     * Listener for the withdrawal button on UI.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amount = GenericWindow.INVALID_INPUT;
            String rawText = WithdrawDepositWindow.super.getUserInput();

            if (GenericWindow.INVALID_INPUT != (amount = GenericWindow.convertStringToDouble(rawText))) {
                if (!WithdrawDepositWindow.this.account.withdrawFunds(amount)) {
                    WithdrawDepositWindow.super.setLabel("Insufficient funds: Please enter a value that is less than $"
                            + account.getBalance() + ".");
                } else {
                    WithdrawDepositWindow.this.printBalance();
                }
            } else {
                WithdrawDepositWindow.super.setLabel("Invalid input: Please enter a numeric value.");
            }
        }
    };

    /**
     * Produces a window that allows user to withdraw or deposit ot their account.
     *
     * @param width Width of window.
     * @param height Height of window.
     * @param account Account object which should have users balance initialized.
     */
    WithdrawDepositWindow(int width, int height, Account account) {
        super(new GenericWindowBuilder(width, height)
                .setButtonText("Deposit")
                .build());
        this.account = account;
        // This must be called after this.account is initialized.
        this.printBalance();
        this.jButton = new JButton("Withdraw");
        this.jButton.addActionListener(actionListener);
        super.getGridbagLayout().setConstraints(jButton, super.getGridbagConstraints());
        super.panel.add(jButton);
    }

    /**
     * Moved this to a method to prevent redundantly setting the same message. Apparently JLable supports HTML so newline
     * character is ignored, so need to use HTML in String with <br> tag to get a newline.
     * <br>See:
     * <a href="https://forums.oracle.com/ords/apexds/post/how-to-insert-a-new-line-in-a-jlabel-2806">
     *     https://forums.oracle.com/ords/apexds/post/how-to-insert-a-new-line-in-a-jlabel-2806</a>
     */
    private void printBalance() {
        WithdrawDepositWindow.super.setLabel("<html>BalanceL: " + account.getBalance()
                + "<br>Select whether you would like to withdraw or deposit.</html>");
    }

    /**
     * Listener for the deposit button on UI.
     */
    @Override
    public void onButtonPressed() {
        double amount = GenericWindow.INVALID_INPUT;
        String rawText = super.getUserInput();

        if (GenericWindow.INVALID_INPUT != (amount = GenericWindow.convertStringToDouble(rawText))) {
            this.account.depositFunds(amount);
            this.printBalance();
        } else {
            super.setLabel("Invalid input: Please enter a numeric value.");
        }
    }
}
