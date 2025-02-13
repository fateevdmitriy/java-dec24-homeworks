package ru.otus.java.basic.homeworks.homework12;

public class Plate {
    int maxAmount;
    int curAmount;

    public Plate(int maxAmount) {
        this.maxAmount = maxAmount;
        this.curAmount = maxAmount;
    }
    
    public boolean isFull() {
        return curAmount == maxAmount; 
    }
    
    public void addFood(int amount) {
        int newAmount = curAmount + amount;
        if (newAmount > 0) {
            if (newAmount > maxAmount) {
                curAmount = maxAmount;
            } else {
                curAmount = newAmount; 
            }
        } else {
            curAmount = 0;
        }
    }
    
    public boolean reduceFood(int amount) {
        int newAmount = curAmount - amount;
        if (newAmount >= 0) {
            if (newAmount > maxAmount) {
                curAmount = maxAmount;   
            } else {
                curAmount = newAmount;
            }
            return true;
        }
        curAmount = 0;
        return false;
    }
    
    public String info() {
        return "Тарелка содержит количество корма "+curAmount+" из максимально возможного "+maxAmount+".\n";
    }
    
}
