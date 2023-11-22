package me.minikuma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("패스워드 초기화한다.")
    void passwordTest() {
        // given
        User user = new User();
        // when
        // user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "12adbdeq");
        // then
        Assertions.assertThat(user.getPassword()).isNotNull();
    }

    @Test
    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는 경우")
    void passwordNotRequirement() {
        // given
        User user = new User();
        // when
        user.initPassword(() -> "ab");
        // then
        Assertions.assertThat(user.getPassword()).isNull();
    }
}