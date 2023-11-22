package me.minikuma.password;

import me.minikuma.RandomPassword;
import org.passay.*;

public class RandomPasswordGenerator implements RandomPassword {
    public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()";
    public static final String ERROR_CODE = "ERRORNEOUS_SPECIAL_CHARS";

    public String generatorPassword() {
        PasswordGenerator generator = new PasswordGenerator();

        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return ERROR_CODE;
            }

            @Override
            public String getCharacters() {
                return ALLOWED_SPL_CHARACTERS;
            }
        };

        CharacterRule specialRule = new CharacterRule(specialChars);
        specialRule.setNumberOfCharacters(2);

        // 0 ~ 12
        return generator.generatePassword((int)(Math.random() * 13), specialRule, lowerCaseRule, upperCaseRule, digitRule);
    }
}
