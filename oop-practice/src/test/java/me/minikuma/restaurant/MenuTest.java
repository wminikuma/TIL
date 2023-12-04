package me.minikuma.restaurant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class MenuTest {

    private Menu menu;

    @BeforeEach
    void before() {
        this.menu = new Menu(List.of(
                new MenuItem("만두", 10000),
                new MenuItem("칼국수", 8000),
                new MenuItem("수제비", 9000)
        ));
    }

    @DisplayName("메뉴판에서 메뉴 이름에 해당하는 이름을 반환한다.")
    @Test
    void selectMenu() {
        MenuItem menuItem = menu.select("만두");
        Assertions.assertThat(menuItem).isEqualTo(new MenuItem("만두", 10000));
    }

    @DisplayName("메뉴판에 없는 메뉴인 경우 에러를 반환 한다.")
    @Test
    void notFoundMenuItemTest() {
        Assertions.assertThatCode(() -> menu.select("치킨"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름 입니다.");
    }
}
