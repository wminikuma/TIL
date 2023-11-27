package me.minikuma.calculator.code;

import me.minikuma.calculator.NewArithmeticOperator;
import me.minikuma.calculator.PositiveNumber;

public class Subtraction implements NewArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculator(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
