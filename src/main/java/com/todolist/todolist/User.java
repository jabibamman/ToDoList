package com.todolist.todolist;


import java.time.LocalDate;

public class User {
    private String email, fname, lname, password;
    LocalDate birthDate;

    public User(String email, String fname, String lname, LocalDate birthDate, String password) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.birthDate = birthDate;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isValidPassword() throws Exception {
        if(this.password.length() < 8  || this.password.length() > 40) {
            throw PasswordsException.invalidLength();
        }

        if(!this.password.matches(".*[A-Z].*")) {
            throw PasswordsException.noUpperCase();
        }

        if(!this.password.matches(".*[a-z].*")) {
            throw PasswordsException.noLowerCase();
        }

        if(!this.password.matches(".*\\d.*")) {
            throw PasswordsException.noNumber();
        }

        return true;
    }

    public boolean isValidEmail() throws ValidationException {
        if(!email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new ValidationException("Invalid email");
        }

        return true;
    }

    public boolean isValidBirthday() throws ValidationException {
        if(this.getBirthDate().isAfter(LocalDate.now().minusYears(13))) {
            throw new ValidationException("Invalid birth date");
        }
        
        return true;
    }

    public boolean isValidFname() throws ValidationException {
        if (fname.isEmpty()) {
            throw new ValidationException("Invalid first name");
        }

        return true;
    }

    public boolean isValidLname() throws ValidationException {
        if (lname.isEmpty()) {
            throw new ValidationException("Invalid last name");
        }

        return true;
    }

    public boolean isValid() throws Exception {
        this.isValidPassword();
        this.isValidEmail();
        this.isValidBirthday();
        this.isValidFname();
        this.isValidLname();

        return true;
    }
}
