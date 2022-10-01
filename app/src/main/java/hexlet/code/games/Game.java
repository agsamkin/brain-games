package hexlet.code.games;

import java.util.Scanner;

public interface Game {
    void hello();

    boolean play();

    default boolean checkResult(int correctAnswer) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your answer: ");

        int answer;
        try {
            answer = sc.nextInt();
        } catch (Exception e) {
            return false;
        }

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        } else {
            String msg = "'" + answer + "' is wrong answer ;(. Correct answer was '"
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
