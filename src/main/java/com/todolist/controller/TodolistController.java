package com.todolist.controller;

import com.todolist.Item;
import com.todolist.ToDoList;
import com.todolist.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodolistController {
    private User user;
    static final Logger LOGGER = LoggerFactory.getLogger(TodolistController.class);


    @FXML
    private TextField taskNameField;

    @FXML
    private TextField taskContentField;

    @FXML
    private ListView<Item> taskList;

    private ToDoList toDoList;

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    // fonction s'exécutant au lancement de la fenêtre
    @FXML
    public void initialize() {
        taskList.setCellFactory(param -> new ListCell<Item>() {
            @Override
            protected void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName() + " | " + item.getContent());
                }
            }
        });
    }

    @FXML
    public void onAddTask() {
        String taskName = taskNameField.getText();
        String taskContent = taskContentField.getText();
        Item item = new Item(taskName, taskContent);
        toDoList.addItem(item);
        taskList.getItems().add(item);
        taskNameField.clear();
        taskContentField.clear();
        LOGGER.info("Task {}, added", item.getName());
    }

    public void setUser(User user) {
        this.user = user;
        this.toDoList = user.getToDoList();
    }
}