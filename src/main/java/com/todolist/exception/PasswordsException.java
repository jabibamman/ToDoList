package com.todolist.exception;

public class PasswordsException extends Exception {
    private final String message;

    public PasswordsException(String message) {
        super(message);
        this.message = message;
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

    @Override
    public String getMessage() {
        return message;
    }
}
