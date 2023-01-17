package com.todolist.utils;

import com.todolist.ValidationException;

import java.time.LocalDate;

public class VerifyBirthDate {
    public VerifyBirthDate() { throw new AssertionError("No com.todolist.utils.VerifyBirthDate instances for you!"); }

    public boolean isValidStr(LocalDate birthDate) throws Exception {
        if(birthDate.isAfter(LocalDate.now().minusYears(13))) throw new ValidationException("Invalid birth date");
        return true;
    }
}
