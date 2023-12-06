package me.minikuma.caculator;

public interface NewArithmeticOperator {
    // 지원 하는 연산자 인지 판단
    boolean support(String operator);
    // 연산 수행
    int caculator(int operand1, int operand2);
}
