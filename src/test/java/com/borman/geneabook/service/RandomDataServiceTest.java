package com.borman.geneabook.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RandomDataServiceTest {

    @Test
    void givenAlphaStringWhenGetTokenThenVerifyCharInTokenAndLength() {
        RandomDataService rndDataObj = new RandomDataService();

        String rndData = rndDataObj.getToken();

        String alphaString = "0123456789"
                + "QWERTYUIOPASDFGHJKLZXCVBNM"
                + "qwertyuiopasdfghjklzxcvbnm";

//        assertThat(List.of(rndData.toCharArray()), containsInAnyOrder( List.of(alphaString.toCharArray())));
        assertThat(rndData, matchesPattern("[0-9a-zA-Z]{64}"));

    }

    @Test
    void getRandomPass() {
        RandomDataService rndDataObj = new RandomDataService();

        String rndData = rndDataObj.getRandomPass();

        String betaString = "0123456789"
                + "QWERTYUIOPASDFGHJKLZXCVBNM"
                + "qwertyuiopasdfghjklzxcvbnm"
                + "!@#$%&?";

        assertThat(rndData, matchesPattern("[0-9a-zA-Z!@#$%&?]{12}"));

    }

    @Test
    void getUUID() {
        RandomDataService rndDataObj = new RandomDataService();

        String rndData = rndDataObj.getUUID();

        assertThat(rndData, matchesPattern("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}"));
    }

    @Test
    void verificationEmail() {
        String email1 = "a.a.aaaa@aa.aaa";
        String email2 = "a.aaaaaa@aa.aaa";
        String email3 = "a.a.aaaa-aa.aaa";
        String email4 = "a.a-aaaa@aa.aaa";
        String email5 = "a.a_aaaa@aa.aaa";
        String email6 = "a.a.aaaa@aaaaa";

        RandomDataService rndDataObj = new RandomDataService();

        assertThat(email1, not(rndDataObj.verificationEmail(email1)));
        assertThat(email2, rndDataObj.verificationEmail(email2));
        assertThat(email3, not(rndDataObj.verificationEmail(email3)));
        assertThat(email4, rndDataObj.verificationEmail(email4));
        assertThat(email5, rndDataObj.verificationEmail(email5));
        assertThat(email6, not(rndDataObj.verificationEmail(email6)));

    }
}