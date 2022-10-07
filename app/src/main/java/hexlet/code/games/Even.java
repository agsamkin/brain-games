package hexlet.code.games;

import hexlet.code.Task;

import java.util.Random;

public final class Even implements Game {

    private static final int MAX_NUMBER = 100;

    @Override
    public String getRules() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    @Override
    public Task getTask() {
        Random random = new Random();
        int number = random.nextInt(MAX_NUMBER);

        String question = "Question: " + number;
        String correctAnswer = number % 2 == 0 ? "yes" : "no";

        return new Task(question, correctAnswer);
    }
}
