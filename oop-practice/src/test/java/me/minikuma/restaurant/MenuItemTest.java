package me.minikuma.restaurant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuItemTest {
    @DisplayName("메뉴 항목을 생성 한다.")
    @Test
    void createMenuTest() {
        Assertions.assertThatCode(() -> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
