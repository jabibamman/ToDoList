package com.todolist.utils;

import com.todolist.exception.ValidationException;

public class VerifyFname {
    public VerifyFname() {}
    public boolean isValidStr(String fname) throws ValidationException {
        if (fname.isEmpty()) throw new ValidationException("Invalid first name");
        fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
        return fname.matches("[A-Z][a-z]+");
    }

}
