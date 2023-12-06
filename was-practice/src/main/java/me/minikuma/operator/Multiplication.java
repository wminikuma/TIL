package me.minikuma.operator;

import me.minikuma.caculator.NewArithmeticOperator;

/**
 * 곱센 연산자
 */
public class Multiplication implements NewArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "*".equals(operator);
    }

    @Override
    public int caculator(int operand1, int operand2) {
        return operand1 * operand2;
    }
}
