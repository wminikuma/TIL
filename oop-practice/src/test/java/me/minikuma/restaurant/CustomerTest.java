package me.minikuma.restaurant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 음식점에서 음식 주문하기
 *
 */

class CustomerTest {
    @DisplayName("메뉴 이름에 해당하는 메뉴를 주문을 한다.")
    @Test
    void orderMenuTest() {
        Customer customer = new Customer();
        // 메뉴, 메뉴 항목, 요리사 전달
        Menu menu = new Menu(List.of(
                new MenuItem("만두", 10000),
                new MenuItem("칼국수", 8000),
                new MenuItem("수제비", 9000)
        ));

        Cooking cooking = new Cooking();

        Assertions.assertThatCode(() -> customer.order("만두", menu, cooking))
                .doesNotThrowAnyException();
    }
}
