package com.todolist.utils;

import com.todolist.PasswordsException;

public class VerifyPassword<T> implements TodoTils {

    @Override
    public boolean isValidObj(Object password) throws Exception {
        if(String.valueOf(password).length() < 8  || String.valueOf(password).length() > 40) {
            throw PasswordsException.invalidLength();
        }

        if(!String.valueOf(password).matches(".*[A-Z].*")) {
            throw PasswordsException.noUpperCase();
        }

        if(!String.valueOf(password).matches(".*[a-z].*")) {
            throw PasswordsException.noLowerCase();
        }

        if(!String.valueOf(password).matches(".*\\d.*")) {
            throw PasswordsException.noNumber();
        }

        return true;
    }

    public VerifyPassword() {}

}
