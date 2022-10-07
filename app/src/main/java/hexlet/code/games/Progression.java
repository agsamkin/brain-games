package hexlet.code.games;

import hexlet.code.Task;

import java.util.Random;

public final class Progression implements Game {

    private static final int PROGRESSION_LENGTH = 10;

    private static final int MIN_DELTA_VALUE = -3;
    private static final int MAX_DELTA_VALUE = 4;

    private static final int MIN_VALUE_START_ELEMENT = 0;
    private static final int MAX_VALUE_START_ELEMENT = 20;

    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }

    @Override
    public Task getTask() {
        Random random = new Random();

        int secretPosition = random.nextInt(0, PROGRESSION_LENGTH);

        int delta = random.nextInt(MIN_DELTA_VALUE, MAX_DELTA_VALUE);
        delta = delta == 0 ? 1 : delta;

        int startElement = random.nextInt(MIN_VALUE_START_ELEMENT, MAX_VALUE_START_ELEMENT);

        int correctAnswer = 0;

        String question = "Question: ";
        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            if (i == secretPosition) {
                correctAnswer = startElement;
                question += ".. ";
            } else {
                question += startElement + " ";
            }
            startElement += delta;
        }

        return new Task(question, String.valueOf(correctAnswer));
    }

}
