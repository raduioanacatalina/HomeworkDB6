package com.raducatalinahomework6.raducatalinahomework6.exception;

public class NoDoctorException extends Exception{
    public NoDoctorException(){
        super("Doctor doesn't exist!");
    }
}
