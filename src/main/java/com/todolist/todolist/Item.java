package com.todolist.todolist;

import java.time.LocalDateTime;

public class Item {
    private String name;
    private String content;
    LocalDateTime dateCreation;

    public Item(String name, String content) {
        this.name = name;
        this.content = content;
        this.dateCreation = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
}
