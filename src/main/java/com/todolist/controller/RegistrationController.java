package com.todolist.controller;

import com.todolist.Main;
import com.todolist.User;
import com.todolist.utils.TodoTils;
import com.todolist.utils.VerifyPassword;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class RegistrationController {
    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    VerifyPassword verifyPassword = new VerifyPassword();

    @FXML
    private TextField emailField;

    @FXML
    private TextField fnameField;

    @FXML
    private TextField lnameField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    public void onRegister() throws Exception {
        String email = emailField.getText();
        String fname = fnameField.getText();
        String lname = lnameField.getText();

        LocalDate birthDate = birthDatePicker.getValue();
        birthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());

        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        // q: i have isValidObj in TodoTils interface, i use in verifypassword, how i can use into RegistrationController?
        // a: you can use it like this:
        if (password.equals(confirmPassword) && verifyPassword.isValidObj(password)) {
            User user = new User(email, fname, lname, birthDate, password);
            LOGGER.debug("{}", user);
        } else {
            errorLabel.setText("Passwords do not match");
        }
    }
}
