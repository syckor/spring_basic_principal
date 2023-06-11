package com.example.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    /*다른 곳에서 객체 생성을 못하게 막으려고 private 생성자를 만듬*/
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }
}
