package com.todolist.utils;

import com.todolist.ValidationException;

public class VerifyLname {
    public boolean isValidStr(String lname) throws ValidationException {
        if (lname.isEmpty()) throw new ValidationException("Invalid last name");
        return true;
    }
}
