package ru.otus.java.basic.homeworks.homework12;

public class Plate {
    private final int maxAmount;
    private int curAmount;

    public Plate(int maxAmount) {
        this.maxAmount = maxAmount;
        this.curAmount = maxAmount;
    }

    public int getCurAmount() {
        return curAmount;
    }

    public boolean isFull() {
        return curAmount == maxAmount; 
    }
    
    public void addFood(int amount) {
        if (amount <= 0) {
            return;
        }
        curAmount += amount;
        if (curAmount > maxAmount) {
            curAmount = maxAmount;
        }         
    }
    
    public boolean reduceFood(int amount) {
        if (amount <= 0) {
            return false;
        }
        curAmount -= amount;
        if (curAmount < 0) {
            curAmount = 0;
            return false;
        }
        return true;
    }                
    
    public String info() {
        return "Тарелка содержит количество корма "+curAmount+" из максимально возможного "+maxAmount+".\n";
    }
    
}
