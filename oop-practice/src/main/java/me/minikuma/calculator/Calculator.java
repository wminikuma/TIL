package me.minikuma.calculator;

import me.minikuma.calculator.code.Addition;
import me.minikuma.calculator.code.Division;
import me.minikuma.calculator.code.Multiplication;
import me.minikuma.calculator.code.Subtraction;

import java.util.List;

public class Calculator {
    private Calculator() {

    }

    private static final List<NewArithmeticOperator> arithmeticOperator = List.of(
            new Addition(),
            new Subtraction(),
            new Multiplication(),
            new Division()
    );

    public static int calculator(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        /* int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                break;
        }
        return result; */
        //return ArithmeticOperator.calculator(operand1, operator, operand2);

        return arithmeticOperator.stream()
                .filter(op -> op.support(operator))
                .map(op -> op.calculator(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));
    }
}
