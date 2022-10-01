package hexlet.code.games;

import java.util.Random;

public final class EvenGame implements Game {
    private final int maxNumber = 100;

    @Override
    public void hello() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
    }

    @Override
    public boolean play() {
        Random random = new Random();
        int number = random.nextInt(maxNumber);
        String correctAnswer = number % 2 == 0 ? "yes" : "no";

        System.out.println("Question: " + number);

        return checkResult(correctAnswer);
    }
}
