package com.todolist.controller;

import com.todolist.exception.PasswordsException;
import com.todolist.TodoListApp;
import com.todolist.app.User;
import com.todolist.exception.ValidationException;
import com.todolist.utils.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistrationController {
    static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
    VerifyPassword verifyPassword = new VerifyPassword();
    VerifyFname verifyFname = new VerifyFname();
    VerifyLname verifyLname = new VerifyLname();
    VerifyEmail verifyEmail = new VerifyEmail();
    VerifyBirthDate verifyBirthDate = new VerifyBirthDate();

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
    public void onRegister() {
        String email = emailField.getText();
        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        LocalDate birthDate;

        try {
            birthDate = parseDate();

            verifyEmail.isValidStr(email);
            verifyFname.isValidStr(fname);
            verifyLname.isValidStr(lname);
            verifyBirthDate.isValidStr(birthDate);
            verifyPassword.isValidStr(password);
            if (!password.equals(confirmPassword)) { throw new PasswordsException("Passwords do not match"); }

            User user = new User(email, fname, lname, birthDate, password);
            LOGGER.debug("User registered successfully with parameters: \n{}", user);
            errorLabel.setVisible(false);

            // change scene to todolist
            changePage(user);

        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
            LOGGER.error(e.getMessage());
        } finally {
            passwordField.setText("");
            confirmPasswordField.setText("");
        }
    }

    @FXML
    public void onCancel() {
        LOGGER.info("Bye bye");
        System.exit(0);
    }

    public LocalDate parseDate() throws ValidationException {
        LocalDate date;
        try {
            date = LocalDate.parse(birthDatePicker.getEditor().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            throw new ValidationException("Invalid birth date");
        }

        return parseDateWithFormat(date);
    }


    public LocalDate parseDateWithFormat(LocalDate birthDateToParse) throws ValidationException {
        try {
            birthDateToParse = LocalDate.of(birthDateToParse.getYear(), birthDateToParse.getMonth(), birthDateToParse.getDayOfMonth());
        } catch (Exception e) {
            errorLabel.setText("Please enter your birth date");
            errorLabel.setVisible(true);
            throw new ValidationException("Please enter your birth date");
        }
        return birthDateToParse;
    }

    public void changePage(User user) {
        try {
            // Charger la vue de la todolist
            FXMLLoader loader = new FXMLLoader(TodoListApp.class.getResource("todolist.fxml"));
            Parent root = loader.load();

            // Récupérer la scène actuelle
            Scene scene = emailField.getScene();

            // Récupérer le contrôleur de la vue de la todolist
            TodolistController todolistController = loader.getController();

            // Définir l'utilisateur dans le contrôleur de la vue de la todolist
            todolistController.setUser(user);

            // Définir la nouvelle scène comme la scène actuelle
            scene.setRoot(root);
        } catch (IOException e) {
            LOGGER.error("Error loading todolist view", e);
            e.printStackTrace();
        }
    }
}
