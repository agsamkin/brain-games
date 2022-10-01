package hexlet.code.games;

import java.util.Scanner;

public interface Game {
    void hello();

    boolean play();

    default boolean checkResult(int correctAnswer) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your answer: ");
        String answerString = sc.next();

        int answer = 0;
        boolean incorrectInput = false;
        try {
            answer = Integer.parseInt(answerString);
        } catch (Exception e) {
            incorrectInput = true;
        }

        if (!incorrectInput && answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        } else {
            String msg = "'" + answerString + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.";
            System.out.println(msg);
            return false;
        }
    }

    default boolean checkResult(String correctAnswer) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your answer: ");
        String answer = sc.next();

        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            String msg = "'" + answer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.";
            System.out.println(msg);
            return false;
        }
    }
}
