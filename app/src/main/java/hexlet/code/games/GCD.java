package hexlet.code.games;

import hexlet.code.Task;

import java.util.Random;

public final class GCD implements Game {
    private static final int MAX_A = 10;
    private static final int MAX_B = 10;

    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public Task getTask() {
        Random random = new Random();

        int a = random.nextInt(MAX_A);
        int b = random.nextInt(MAX_B);

        String question = "Question: " + a + " " + b;
        int correctAnswer = gcd(a, b);

        return new Task(question, String.valueOf(correctAnswer));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
