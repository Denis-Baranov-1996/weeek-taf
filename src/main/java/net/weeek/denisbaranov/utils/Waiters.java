package net.weeek.denisbaranov.utils;

public class Waiters {

    public static final int DEFAULT_WAIT_SECONDS = 4;

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
