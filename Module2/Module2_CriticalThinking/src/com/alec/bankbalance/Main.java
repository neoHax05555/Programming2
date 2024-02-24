package com.alec.bankbalance;

/**
 * Application entry point.
 */
public class Main {
    /**
     * Main method holds instance of the {@link WindowMgr} instance.
     *
     * @param args args from when invoked on cmdline.
     */
    public static void main(String[] args) {
        new WindowMgr();
    }

    /**
     * Contained most of the logic within an inner static class so that
     */
    private static class WindowMgr {
        /*
         * Constants begin.
         */
        /**
         * Size of the window to apply with aspect ratio.
         */
        public static final int WINDOW_SIZE = 40;
        /**
         * The aspect ratio of the app will be 16*9 to match most modern displays.
         */
        public static final int WINDOW_WIDTH_ASPECT_RATIO = 16;
        /**
         * The aspect ratio of the app will be 16*9 to match most modern displays.
         */
        public static final int WINDOW_HEIGHT_ASPECT_RATIO = 9;
        /**
         * The final width of the window, the size*width.
         */
        public static final int WINDOW_WIDTH = WINDOW_SIZE * WINDOW_WIDTH_ASPECT_RATIO;
        /**
         * The final width of the window, the size*height.
         */
        public static final int WINDOW_HEIGHT = WINDOW_SIZE * WINDOW_HEIGHT_ASPECT_RATIO;

        /*
         * Member variables begin.
         */
        PromptBalanceWindow promptBalanceWindow;
        WithdrawDepositWindow withdrawDepositWindow;

        /**
         * Window manager, this is where we start up the first window.
         */
        WindowMgr(){
            promptBalanceWindow = new PromptBalanceWindow(WINDOW_WIDTH, WINDOW_HEIGHT, doCallback(),
                    "Please enter the balance of your account.", "enter");
            promptBalanceWindow.setVisible(true);
        }

        /**
         * This is sooo cool, I have never thought to do this before and I have no clue why. I figured out how to have a
         * method return the defined callback Object to separate this from my other method, in this instance my callback
         * happens to use a single Method interface.
         *
         * @return A defined AccountCallback Object.
         */
        private AcountCallback doCallback() {
            return account -> {
                promptBalanceWindow.setVisible(false);
                // Dereference for GC.
                promptBalanceWindow = null;
                withdrawDepositWindow = new WithdrawDepositWindow(WINDOW_WIDTH, WINDOW_HEIGHT, account);
                withdrawDepositWindow.setVisible(true);
            };
        }
    }
}
