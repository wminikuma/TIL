package me.minikuma;

import me.minikuma.calculator.PositiveNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void creatTest(int value) {
        Assertions.assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
