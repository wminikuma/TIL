package me.minikuma.calculator;

public interface NewArithmeticOperator {
    boolean support(String operator);
    int calculator(PositiveNumber operand1, PositiveNumber operand2);
}
