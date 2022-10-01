package hexlet.code.games;

import java.util.Random;

public final class GCDGame implements Game {
    private final int maxA = 10;
    private final int maxB = 10;

    @Override
    public void hello() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    public boolean play() {
        Random random = new Random();

        int a = random.nextInt(maxA);
        int b = random.nextInt(maxB);

        int correctAnswer = gcd(a, b);

        System.out.println("Question: " + a + " " + b);
        return checkResult(correctAnswer);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
