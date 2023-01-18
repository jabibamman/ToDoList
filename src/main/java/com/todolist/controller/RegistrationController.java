package com.todolist.controller;

import com.todolist.TodoListApp;
import com.todolist.User;
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
    public void onRegister() throws Exception {
        String email = emailField.getText();
        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        LocalDate birthDate = birthDatePicker.getValue();
        birthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());

        if (password.equals(confirmPassword) && verifyPassword.isValidStr(password) && verifyFname.isValidStr(fname)
                && verifyLname.isValidStr(lname)
                && verifyEmail.isValidStr(email)
                && verifyBirthDate.isValidStr(birthDate))
        {
            User user = new User(email, fname, lname, birthDate, password);
            LOGGER.debug("User registered successfully with parameters: {}", user);

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
        } else {
            errorLabel.setText("Invalid registration parameters");
            LOGGER.warn("Invalid registration parameters");
        }
    }

    @FXML
    public void onCancel() {
        LOGGER.info("Bye bye");
        System.exit(0);
    }
}
