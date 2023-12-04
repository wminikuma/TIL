package me.minikuma.restaurant;

public class Customer {
    public void order(String menuName, Menu menu, Cooking cooking) {
        MenuItem findMenu = menu.select(menuName);
        Cook cook = cooking.makeCook(findMenu);
        System.out.println("만들어진 요리는 = " +  cook);
    }
}
