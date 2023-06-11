package com.example.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드
    //singleton을 사용할 때는 stateless하게 작동될 수 있도록 설계하자
    public void order(String name, int price){
        System.out.println("name " + name + "price = " + price);
        this.price = price; //this point have problem!
    }

    public int getPrice(){
        return price;
    }
}
