package com.iqbalnetwork.controllers.exception;

public class NotValidPaymentException extends Exception {
    public NotValidPaymentException() {
        super("Transaction Type is unknown..");
    }
}
