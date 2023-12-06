package me.minikuma.caculator;

import me.minikuma.operator.Addition;
import me.minikuma.operator.Division;
import me.minikuma.operator.Multiplication;
import me.minikuma.operator.Subtraction;

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

    public static int calculator(int operand1, String operator, int operand2) {
        return arithmeticOperator.stream()
                .filter(op -> op.support(operator))
                .map(op -> op.caculator(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
