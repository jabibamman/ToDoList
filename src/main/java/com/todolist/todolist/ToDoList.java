package com.todolist.todolist;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private final ArrayList<Integer> itemList = new ArrayList<Integer>();

    public void initList(){
        for(int i = 1; i<8; i++){
            this.itemList.add(i);
        }
    }
    public void addItem(int value){
        if(this.lastTwoItems()){
            System.out.println("Il ne reste de place que pour 2 derniers items");
        }
        this.itemList.add(value);
    }

    public void displayToDoList(){
        System.out.println(this.itemList);
    }

    public boolean lastTwoItems(){
        if(this.itemList.size() == 7){
            EmailSenderService emailSender = new EmailSenderService();
            return emailSender.sendEmail();
        }

        return false;
    }
}
