package hexlet.code.games;

import hexlet.code.Task;

import java.util.Random;

public final class Prime implements Game {
    private static final int MAX_NUMBER = 100;

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public Task getTask() {
        Random random = new Random();
        int number = random.nextInt(MAX_NUMBER);

        String question = String.valueOf(number);
        String correctAnswer = isPrime(number) ? "yes" : "no";

        return new Task(question, correctAnswer);
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
