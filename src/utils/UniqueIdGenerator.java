package utils;

import java.util.Random;

public class UniqueIdGenerator {
    public static int generate() {
        Random rand = new Random();
        return rand.nextInt((999 - 1) + 1) + 1;
    }
}
