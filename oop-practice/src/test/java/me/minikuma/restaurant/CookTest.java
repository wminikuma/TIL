package me.minikuma.restaurant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CookTest {
    @DisplayName("요리를 만든다.")
    @Test
    void createCook() {
        Assertions.assertThatCode(() -> new Cook("만두", 5000))
                .doesNotThrowAnyException();
    }
}
