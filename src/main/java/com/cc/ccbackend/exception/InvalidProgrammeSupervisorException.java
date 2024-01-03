package com.cc.ccbackend.exception;

import java.util.UUID;

public class InvalidProgrammeSupervisorException extends RuntimeException{

    public InvalidProgrammeSupervisorException(UUID id) {
        super(String.format("Provided supervisor ID %s is not valid",id.toString()));
    }
}
