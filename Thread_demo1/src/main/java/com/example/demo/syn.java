package com.example.demo;

public class syn implements Runnable {

	 Bank1 b = new Bank1();
	    @Override 
	    public void run() {
	        synchronized(this){
	        	
	            for (int i = 0; i < 3; i++) {
	                b.add(100);
	            }
	        }
	    }
	    
/*
 * 
 * 	    @Override 
	    public synchronized void run() {
            for (int i = 0; i < 3; i++) {
                b.add(100);
	        }
	    }
 */
}
