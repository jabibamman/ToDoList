package com.todolist.controller;

import com.todolist.Item;
import com.todolist.ToDoList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
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

    @FXML
    public void onAddTask() {
        String taskName = taskNameField.getText();
        String taskContent = taskContentField.getText();
        Item item = new Item(taskName, taskContent);
        toDoList.addItem(item);
        taskList.getItems().add(item);
        taskNameField.clear();
        taskContentField.clear();
    }
}