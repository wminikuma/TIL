package me.minikuma;

import me.minikuma.calculator.Calculator;
import me.minikuma.calculator.PositiveNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 연산 테스트 코드 작성
 */
class CalculatorTest {
    @ParameterizedTest
    @DisplayName("연산 테스트 (+, -, *, /)")
    @MethodSource("formulaAndResult")
    void additionTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result) {
        int calculatorResult = Calculator.calculator(operand1, operator, operand2);
        Assertions.assertThat(calculatorResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                Arguments.arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
                Arguments.arguments(new PositiveNumber(2), "-", new PositiveNumber(1), 1),
                Arguments.arguments(new PositiveNumber(2), "*", new PositiveNumber(1), 2),
                Arguments.arguments(new PositiveNumber(2), "/", new PositiveNumber(1), 2)
        );
    }

    /*@Test
    @DisplayName("0으로 나눴을 때 IllegalArgument Exception이 발생한다.")
    void calculatorExceptionTest() {
        Assertions.assertThatCode(() ->Calculator.calculator(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없다");
    }*/
}
