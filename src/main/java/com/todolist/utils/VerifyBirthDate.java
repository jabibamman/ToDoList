package com.todolist.utils;

import com.todolist.exception.ValidationException;

import java.time.LocalDate;

public class VerifyBirthDate {
    public VerifyBirthDate() {  /* Default constructor */ }

    public boolean isValidStr(LocalDate birthDate) throws Exception {
        if(birthDate.isAfter(LocalDate.now().minusYears(13))) throw new ValidationException("Invalid birth date");
        return true;
    }
}
