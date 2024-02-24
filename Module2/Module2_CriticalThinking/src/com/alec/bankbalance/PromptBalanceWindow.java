package com.alec.bankbalance;

/**
 * The Prompt balance window overrides the {@link GenericWindow} class.
 */
public class PromptBalanceWindow extends GenericWindow {
    /**
     * Callback to return an initialized account Object.
     */
    AcountCallback callback;

    /**
     * The Prompt balance window
     * @param width
     * @param height
     * @param acountCallback
     * @param labelText
     * @param buttonText
     */
    PromptBalanceWindow(int width, int height, AcountCallback acountCallback, String labelText, String buttonText) {
        super(new GenericWindowBuilder(width, height)
                .setLabel(labelText)
                .setButtonText(buttonText)
                .build());
        this.callback = acountCallback;
    }

    /**
     * Override the abstract method from {@link GenericWindow} class.
     */
    @Override
    public void onButtonPressed() {
        String rawText = super.getUserInput();
        double amount;
        Account account = new Account();

        if (GenericWindow.INVALID_INPUT != (amount = GenericWindow.convertStringToDouble(rawText))) {
            account.depositFunds(amount);
            callback.accountInitialized(account);
        } else {
            super.setLabel("Invalid input: Please enter a numeric value.");
        }
    }
}
