package hexlet.code.games;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiFunction;

public final class CalcGame implements Game {
    private final int numberOfOperations = 3;
    private final int maxA = 10;
    private final int maxB = 10;

    @Override
    public void hello() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public boolean play() {
        Random random = new Random();
        int a = random.nextInt(maxA);
        int b = random.nextInt(maxB);

        int operationNumber = getOperationNumber();
        String operationDesc = Operation.getOperationDescByNumber(operationNumber);
        BiFunction<Integer, Integer, Integer> operation = Operation.getOperationByNumber(operationNumber);

        int correctAnswer = operation.apply(a, b);

        System.out.println("Question: " + a + " " + operationDesc + " " + b);

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
        return random.nextInt(numberOfOperations);
    }

    private enum Operation {
        PLUS(0, "+", (a, b) -> a + b),
        MINUS(1, "-", (a, b) -> a - b),
        MULTIPLY(2, "*", (a, b) -> a * b);

        private final int operationNumber;
        private final String operationDescription;
        private final BiFunction<Integer, Integer, Integer> operation;

        Operation(int operationNumber, String operationDescription, BiFunction<Integer, Integer, Integer> operation) {
            this.operationNumber = operationNumber;
            this.operationDescription = operationDescription;
            this.operation = operation;

        }

        public int getOperationNumber() {
            return operationNumber;
        }

        public String getOperationDescription() {
            return operationDescription;
        }

        public BiFunction<Integer, Integer, Integer> getOperation() {
            return operation;
        }

        public static String getOperationDescByNumber(int operationNumber) {
            Optional<Operation> result = findOperationByNumber(operationNumber);
            if (result.isPresent()) {
                return result.get().getOperationDescription();
            } else {
                throw new UnsupportedOperationException(String.valueOf(operationNumber));
            }
        }

        public static BiFunction<Integer, Integer, Integer> getOperationByNumber(int operationNumber) {
            Optional<Operation> result = findOperationByNumber(operationNumber);
            if (result.isPresent()) {
                return result.get().getOperation();
            } else {
                throw new UnsupportedOperationException(String.valueOf(operationNumber));
            }
        }

        private static Optional<Operation> findOperationByNumber(int operationNumber) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getOperationNumber() == operationNumber)
                    .findFirst();
        }
    }
}
