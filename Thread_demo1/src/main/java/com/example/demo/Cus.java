package com.example.demo;

public class Cus implements Runnable{

    Bank b = new Bank();
    @Override
    public void run() {
    	
        for (int i = 0; i < 3; i++) {
            b.add(100);
        }
    }
}