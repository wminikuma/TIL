package me.minikuma;

public class User {
    private String password;

    public void initPassword(RandomPassword randomPassword) {
        String password = randomPassword.generatorPassword();
        /**
         * 비밀번혼 8자리 이상 ~ 12자리 이하
         */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
