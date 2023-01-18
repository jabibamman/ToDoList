package com.todolist.utils;

import com.todolist.exception.ValidationException;

public class VerifyLname {
    public VerifyLname() {}

    public boolean isValidStr(String lname) throws ValidationException {
        if (lname.isEmpty()) throw new ValidationException("Invalid last name");
        lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
        return lname.matches("[A-Z][a-z]+");
    }
}
