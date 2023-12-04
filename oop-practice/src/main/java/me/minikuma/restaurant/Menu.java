package me.minikuma.restaurant;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem select(String menuName) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름 입니다."));
    }
}
