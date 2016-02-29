package com.design.simple;

public class Singleton2 {
	private static Singleton2 instance = null;  
	  
    private Singleton2() {  
    }  
  
    private static synchronized void syncInit() {  
    	synchronized (instance) {
    		if (instance == null) {  
    			instance = new Singleton2();  
    		}  
		}
    }  
  
    public static Singleton2 getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
}
