package com.todolist.utils;

import com.todolist.ValidationException;

public class VerifyFname {
    public boolean isValidStr(String fname) throws ValidationException {
        if (fname.isEmpty()) throw new ValidationException("Invalid first name");
        return fname.matches("[A-Z][a-z]+");
    }

}
