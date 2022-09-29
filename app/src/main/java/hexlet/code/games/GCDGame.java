package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GCDGame implements Game {
    @Override
    public void hello() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    public boolean play() {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);

        int correctAnswer = gcd(a, b);

        System.out.println("Question: " + a + " " + b);

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

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
