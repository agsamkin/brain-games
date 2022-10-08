package hexlet.code.games;

import hexlet.code.Task;

import java.util.Random;

public final class Even implements Game {

    private static final int MAX_NUMBER = 100;

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public Task getTask() {
        Random random = new Random();
        int number = random.nextInt(MAX_NUMBER);

        String question = String.valueOf(number);
        String correctAnswer = isEven(number) ? "yes" : "no";

        return new Task(question, correctAnswer);
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

}
