package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    public static void start() {

        System.out.println("Answer 'yes' if number even otherwise answer 'no'.  ");

        int countOfCorrectAnswers = 0;

        while (countOfCorrectAnswers < 3) {
            if (isCorrectAnswer()) {
                countOfCorrectAnswers++;
            } else {
                break;
            }
        }

        if (countOfCorrectAnswers == 3) {
            System.out.println("Congratulations, " + Cli.getUsername() + "!");
        }
    }

    private static boolean isCorrectAnswer() {
        Random random = new Random();
        int number = random.nextInt(100);
        String correctAnswer = number % 2 == 0 ? "yes" : "no";

        System.out.println("Question: " + number);

        Scanner sc = new Scanner(System.in);
        System.out.print("Your answer: " );
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
