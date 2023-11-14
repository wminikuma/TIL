package me.minikuma;

public final class PasswordValidator {
    private PasswordValidator() {
        // private constructor
    }
    public static void validate(String password) {
        // check logic 추가
        // password 가 8자 이상, 12자 이하면 예외 발생 하지 않음
        int passwordSize = password.length();

        if (passwordSize < 8 || passwordSize > 12) {
            throw new IllegalArgumentException("password 는 최소 8자 이상, 12자 이하로 구성");
        }
    }
}
