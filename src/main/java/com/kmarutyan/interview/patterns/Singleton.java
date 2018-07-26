package com.kmarutyan.interview.patterns;

public class Singleton {
    private static Singleton INSTANCE = null;
    private Singleton(){
        // do something here
    }

    public static Singleton getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }
}

enum SingletonEnum{
    INSTANCE;
}