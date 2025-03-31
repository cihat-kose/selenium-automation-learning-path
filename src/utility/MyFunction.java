package utility;
public class MyFunction {
    public static void wait(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static int generateRandomNumber(int max) {
        return (int) (Math.random() * max);
    }
}
