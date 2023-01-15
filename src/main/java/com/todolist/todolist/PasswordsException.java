package com.todolist.todolist;

public class PasswordsException extends Exception {
    public PasswordsException(String message) {
        super(message);
    }

    public static Exception invalidLength() {
        return new PasswordsException("Password must be between 8 and 40 characters");
    }

    public static Exception noUpperCase() {
        return new PasswordsException("Password must contain at least one uppercase letter");
    }

    public static Exception noLowerCase() {
        return new PasswordsException("Password must contain at least one lowercase letter");
    }

    public static Exception noNumber() {
        return new PasswordsException("Password must contain at least one number");
    }
}