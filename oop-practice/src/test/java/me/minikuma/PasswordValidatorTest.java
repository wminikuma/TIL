package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 요구사항
 * 1. 비밀번호는 최소 8자 이상 12자 이하
 * 2. 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외 발생
 * 3. 경계 조건에 대해 테스트 코드 작성 필요
 */
class PasswordValidatorTest {
    @Test
    @DisplayName("비밀번호 최소 8자 이상, 12자 이하면 예외 발생하지 않는다.")
    void validatorPasswordTest() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("testpassword"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("비밀번호가 8자리 미만, 12자 초과하는 경우 예외 발생 IllegalArgumentException")
    void validatorPasswordException() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("password 는 최소 8자 이상, 12자 이하로 구성");
    }

    @DisplayName("경계 조건: 7자리, 13자리")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaaa", "abdfdfdedfese"})
    void validatorPasswordBoundaryCondition(String password) {
        Assertions.assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("password 는 최소 8자 이상, 12자 이하로 구성");
    }
}
