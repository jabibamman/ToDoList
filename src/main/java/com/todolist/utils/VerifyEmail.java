package com.todolist.utils;

import com.todolist.exception.ValidationException;

public class VerifyEmail {
    public VerifyEmail() { /* Default constructor */ }

    public boolean isValidStr(String email) throws Exception {
        if(!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) throw new ValidationException("Invalid email");
        return true;
    }
}
