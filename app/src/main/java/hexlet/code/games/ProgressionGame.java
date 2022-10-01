package hexlet.code.games;

import java.util.Random;

public final class ProgressionGame implements Game {

    private final int progressionLength = 10;

    private final int minDeltaValue = -3;
    private final int maxDeltaValue = 4;

    private final int minValueStartElement = 0;
    private final int maxValueStartElement = 20;

    @Override
    public void hello() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    public boolean play() {
        Random random = new Random();

        int secretPosition = random.nextInt(0, progressionLength);

        int delta = random.nextInt(minDeltaValue, maxDeltaValue);
        if (delta == 0) {
            delta = 1;
        }

        int startElement = random.nextInt(minValueStartElement, maxValueStartElement);

        int correctAnswer = 0;

        System.out.print("Question: ");
        for (int i = 0; i < progressionLength; i++) {
            int tmp = startElement;
            if (i == secretPosition) {
                correctAnswer = tmp;
                System.out.print(".. ");
            } else {
                System.out.print(tmp + " ");
            }
            startElement += delta;
        }

        System.out.print("\n");

        return checkResult(correctAnswer);
    }
}
