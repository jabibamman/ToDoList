package com.todolist.todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ToDoList {
    ArrayList<Item> items;
    LocalDateTime dateDernierAjout;

    public ToDoList() {
        items = new ArrayList<>();
    }
    public ToDoList(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if(isAddItemPossible()) {
            items.add(item);
            dateDernierAjout = LocalDateTime.now();
        }
        else {
            throw new RuntimeException("Impossible d'ajouter un item dans la ToDoList");
        }
    }

    public boolean isAddItemPossible() {
        if(items.size() > 10) {
            return false;
        }
        else if(dateDernierAjout.isAfter(LocalDateTime.now().minusMinutes(30))) {
            return false;
        }
        return true;
    }
}
