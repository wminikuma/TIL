package me.minikuma.operator;

import me.minikuma.caculator.NewArithmeticOperator;

/**
 * 나눗셈 연산
 */
public class Division implements NewArithmeticOperator {

    @Override
    public boolean support(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int caculator(int operand1, int operand2) {
        // 수학적으로 나눗셈인 경우 0으로 나눌 수 없음을 고려 (불능)
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나눗셈을 할 수 없다.");
        }
        return operand1 / operand2;
    }
}
