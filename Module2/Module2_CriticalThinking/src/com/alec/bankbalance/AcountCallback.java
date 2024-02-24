package com.alec.bankbalance;

/**
 * Single method interface to pass Account Object back to class holding instance.
 */
public interface AcountCallback {
    /**
     * Pass an instance of account in and define action to be taken.
     */
    void accountInitialized(Account account);
}
