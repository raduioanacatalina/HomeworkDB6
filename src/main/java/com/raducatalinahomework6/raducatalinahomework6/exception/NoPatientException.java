package com.raducatalinahomework6.raducatalinahomework6.exception;

public class NoPatientException extends Exception{
    public NoPatientException(){
        super("The patient doesn't exist!");
    }
}
