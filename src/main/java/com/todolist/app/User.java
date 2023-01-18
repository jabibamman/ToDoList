package com.todolist.app;

import java.time.LocalDate;
import com.todolist.utils.*;

public class User {
    private String email, fname, lname, password;
    LocalDate birthDate;
    ToDoList todoList;

    private VerifyPassword verifyPassword;
    private VerifyFname verifyFname;
    private VerifyLname verifyLname;
    private VerifyEmail verifyEmail;
    private VerifyBirthDate verifyBirthDate;


    public User(String email, String fname, String lname, LocalDate birthDate, String password) throws Exception {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.birthDate = birthDate;
        this.password = password;
        this.todoList = new ToDoList();
        this.verifyPassword = new VerifyPassword();
        this.verifyFname = new VerifyFname();
        this.verifyLname = new VerifyLname();
        this.verifyEmail = new VerifyEmail();
        this.verifyBirthDate = new VerifyBirthDate();
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

    public ToDoList getToDoList() {
        return todoList;
    }

    public boolean isValid() throws Exception {
        verifyEmail.isValidStr(this.email);
        verifyFname.isValidStr(this.fname);
        verifyLname.isValidStr(this.lname);
        verifyBirthDate.isValidStr(this.birthDate);
        verifyPassword.isValidStr(this.password);

        return true;
    }

    @Override
    public String toString() {
        return "User [birthDate=" + birthDate + ", email=" + email + ", fname=" + fname + ", lname=" + lname
                + ", password=" + password + ", todoList=" + todoList + "]";
    }
}
