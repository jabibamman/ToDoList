package com.todolist.todolist;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        ToDoList td = new ToDoList();
        td.displayToDoList();
        td.initList();
        td.displayToDoList();
        td.addItem(8);
        td.displayToDoList();
    }
}
