package me.minikuma.operator;

import me.minikuma.caculator.NewArithmeticOperator;

/**
 * 덧셈 연산자
 */
public class Addition implements NewArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int caculator(int operand1, int operand2) {
        return operand1 + operand2;
    }
}
