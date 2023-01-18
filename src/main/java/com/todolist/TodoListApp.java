package com.todolist;

import com.todolist.config.Log4jConfigurator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoListApp extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoListApp.class.getResource("registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 340);
        stage.setTitle("TodoList");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Log4jConfigurator.configure();
        launch();
    }
}