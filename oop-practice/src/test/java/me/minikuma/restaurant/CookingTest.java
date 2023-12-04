package me.minikuma.restaurant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CookingTest {
    @DisplayName("메뉴 항목에 메뉴를 요리 한다.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스", 10000);

        // 음식 메뉴를 확인해서 요리를 만들어 달라고 요청한다.
        Cook cook = cooking.makeCook(menuItem);

        Assertions.assertThat(cook).isEqualTo(new Cook("돈까스", 10000));
    }
}
