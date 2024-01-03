package com.cc.ccbackend.exception;

public class NullProgrammeException extends RuntimeException{
    public NullProgrammeException() {
        super("You attempted to create a null programme.");
    }
}
