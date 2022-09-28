package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;
import java.util.function.BiFunction;

public class CalcGame implements Game {

    @Override
    public void hello() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public boolean play() {

        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);

        int operationNumber = getOperationNumber();
        String operationStr = getOperationString(operationNumber);
        BiFunction<Integer, Integer, Integer> operation = getOperation(operationNumber);

        int correctAnswer = operation.apply(a, b);

        System.out.println("Question: " + a + " " + operationStr + " " + b);

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

    private int getOperationNumber() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private String getOperationString(int number) {
        if (number == 0) {
            return "+";
        } else if (number == 1) {
            return "-";
        } else if (number == 2) {
            return "*";
        } else {
            throw new UnsupportedOperationException(String.valueOf(number));
        }
    }

    private BiFunction<Integer, Integer, Integer> getOperation(int number) {
        if (number == 0) {
            return (a, b) -> a + b;
        } else if (number == 1) {
            return (a, b) -> a - b;
        } else if (number == 2) {
            return (a, b) -> a * b;
        } else {
            throw new UnsupportedOperationException(String.valueOf(number));
        }
    }

}
