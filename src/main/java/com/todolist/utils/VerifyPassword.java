package com.todolist.utils;

import com.todolist.exception.PasswordsException;

public class VerifyPassword {
    public VerifyPassword() { /* Default constructor */ }

    public boolean isValidStr(String password) throws Exception {
        if(password.length() < 8  || password.length() > 40) {
            throw PasswordsException.invalidLength();
        }

        if(!password.matches(".*[A-Z].*")) {
            throw PasswordsException.noUpperCase();
        }

        if(!password.matches(".*[a-z].*")) {
            throw PasswordsException.noLowerCase();
        }

        if(!password.matches(".*\\d.*")) {
            throw PasswordsException.noNumber();
        }

        return true;
    }
}
