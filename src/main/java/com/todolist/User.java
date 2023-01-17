package com.todolist;

import java.time.LocalDate;

import com.todolist.utils.VerifyPassword;

public class User {
    private String email, fname, lname, password;
    LocalDate birthDate;
    ToDoList todoList;

    public User(String email, String fname, String lname, LocalDate birthDate, String password) throws Exception {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.birthDate = birthDate;
        this.password = password;
        this.todoList = new ToDoList();
        this.isValid();
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
        this.isValidEmail();
        this.isValidFname();
        this.isValidLname();
        this.isValidBirthday();
        // use isValidObj from VerifyPassword class but not static
        VerifyPassword verifyPassword = new VerifyPassword();
        verifyPassword.isValidObj(this.password);

        return true;
    }

    @Override
    public String toString() {
        return "User [birthDate=" + birthDate + ", email=" + email + ", fname=" + fname + ", lname=" + lname
                + ", password=" + password + ", todoList=" + todoList + "]";
    }
}
