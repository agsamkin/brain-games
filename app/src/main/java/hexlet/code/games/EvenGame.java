package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {
    @Override
    public void hello() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
    }

    @Override
    public boolean play() {
        Random random = new Random();
        int number = random.nextInt(100);
        String correctAnswer = number % 2 == 0 ? "yes" : "no";

        System.out.println("Question: " + number);

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
