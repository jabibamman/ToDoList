package com.todolist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    static final Logger LOGGER = LoggerFactory.getLogger(ToDoList.class);
    private final ArrayList<Item> items;
    private LocalDateTime dateDernierAjout;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public ToDoList(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public void addItem(Item item) {
        if(this.isAddItemPossible()) {
            if(this.lastTwoItems()) {
                LOGGER.info("Il ne reste de place que pour 2 derniers items");
            }
            this.items.add(item);
            this.dateDernierAjout = LocalDateTime.now();
        }
        else {
            throw new RuntimeException("Impossible d'ajouter un item dans la ToDoList");
        }
    }

    public boolean isAddItemPossible() {
        if(this.items.size() >= 10) {
            LOGGER.warn("Vous ne pouvez pas ajouter plus de 10 objets");
            return false;
        }
        else if(!this.timerValid()){
            LOGGER.warn("Vous ne pouvez pas ajouter d'objets en moins de 30min");
            return false;
        }
        return true;
    }

    public boolean timerValid(){
        //if(this.dateDernierAjout != null) return !this.dateDernierAjout.isAfter(LocalDateTime.now().minusMinutes(30));
        return true;
    }

    public boolean lastTwoItems(){
        if(this.items.size() != 7) return false;

        EmailSenderService emailSender = new EmailSenderService();
        return emailSender.sendEmail();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if(this.dateDernierAjout != null) {
            result.append("ToDoList (").append(this.items.size()).append(" items, dernier ajout : ").append(this.dateDernierAjout.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append(") :\n");

            for (Item item : this.items) {
                result.append(" - ").append(item.getName()).append(" : ").append(item.getContent()).append(" (").append(item.isContentValid() ? "valide" : "non valide").append(")");
                if (this.items.indexOf(item) == this.items.size() - 1) {
                    result.append("\n");
                } else {
                    result.append(", \n");
                }
            }

        }else{
            result.append("ToDoList (").append(this.items.size()).append(" items)\n");
        }

        return result.toString();
    }
}
