package me.minikuma.calculator.code;

import me.minikuma.calculator.NewArithmeticOperator;
import me.minikuma.calculator.PositiveNumber;

public class Division implements NewArithmeticOperator {
    @Override
    public boolean support(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculator(PositiveNumber operand1, PositiveNumber operand2) {
        // 불능 체크
        /* if (operand2.toInt() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없다");
        }*/
        return operand1.toInt() / operand2.toInt();
    }
}
