package com.borman.geneobook.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RandomDataService {
    private static final String AlphaString = "0123456789"
            + "QWERTYUIOPASDFGHJKLZXCVBNM"
            + "qwertyuiopasdfghjklzxcvbnm";

    private static final String BetaString = AlphaString
            + "!@#$%&?";

    public String getToken() {

        StringBuilder sb = new StringBuilder(64);

        for (int i = 0; i < 64; i++) {
            int index = (int) (AlphaString.length() * Math.random());
            sb.append(AlphaString.charAt(index));
        }
        return sb.toString();
    }

    public String getRandomPass() {

        StringBuilder sb = new StringBuilder(12);

        for (int i = 0; i < 12; i++) {
            int index = (int) (BetaString.length() * Math.random());
            sb.append(BetaString.charAt(index));
        }
        return sb.toString();
    }

    public String getUUID() {
        return UUID.randomUUID().toString();
    }

    public boolean verificationEmail(String email) {

        return email.matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");

    }
}
