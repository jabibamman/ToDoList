package com.todolist.app;

public class Item {
    private final String name;
    private String content;

    public Item(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isContentValid() {
        return content.length() <= 1000;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
