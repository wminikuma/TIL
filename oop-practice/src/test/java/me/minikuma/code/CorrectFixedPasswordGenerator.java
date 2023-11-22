package me.minikuma.code;

import me.minikuma.RandomPassword;

public class CorrectFixedPasswordGenerator implements RandomPassword {
    @Override
    public String generatorPassword() {
        return "12345890";
    }
}
