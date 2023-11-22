package me.minikuma.code;

import me.minikuma.RandomPassword;

public class WrongFixedPasswordGenerator implements RandomPassword {
    @Override
    public String generatorPassword() {
        return "12";
    }
}
