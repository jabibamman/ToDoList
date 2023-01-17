package com.todolist.todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ToDoList {
    private final ArrayList<Item> items;
    private LocalDateTime dateDernierAjout;

    public ToDoList() {
        items = new ArrayList<>();
    }
    public ToDoList(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if(this.isAddItemPossible()) {
            if(this.lastTwoItems()) {
                System.out.println("Il ne reste de place que pour 2 derniers items");
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
            System.out.println("Vous ne pouvez pas ajouter plus de 10 objets");
            return false;
        }
        else if(!this.timerValid()){
            System.out.println("Vous ne pouvez pas ajouter d'objets en moins de 30min");
            return false;
        }
        return true;
    }

    public boolean timerValid(){
        if(this.dateDernierAjout != null) return !this.dateDernierAjout.isAfter(LocalDateTime.now().minusMinutes(30));
        else return true;
    }

    public boolean lastTwoItems(){
        if(this.items.size() != 7) return false;

        EmailSenderService emailSender = new EmailSenderService();
        return emailSender.sendEmail();
    }
}
