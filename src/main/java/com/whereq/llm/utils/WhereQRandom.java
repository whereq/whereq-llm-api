package com.whereq.llm.utils;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class WhereQRandom {

    public static String randomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static String randomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static int getRandomInt(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound + 1);
    }
}
