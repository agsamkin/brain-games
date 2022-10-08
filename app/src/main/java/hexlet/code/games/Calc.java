package hexlet.code.games;

import hexlet.code.Task;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;

public final class Calc implements Game {
    private static final int NUMBER_OF_OPERATIONS = 3;
    private static final int MAX_A = 10;
    private static final int MAX_B = 10;

    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }

    @Override
    public Task getTask() {
        Random random = new Random();

        int a = random.nextInt(MAX_A);
        int b = random.nextInt(MAX_B);

        int operationNumber = random.nextInt(NUMBER_OF_OPERATIONS);
        Operation operation = Operation.getOperation(operationNumber);

        String symbol = operation.symbol;
        BiFunction<Integer, Integer, Integer> function = operation.function;

        String question = a + " " + symbol + " " + b;
        int correctAnswer = function.apply(a, b);

        return new Task(question, String.valueOf(correctAnswer));
    }

    private enum Operation {
        PLUS(0, "+", (a, b) -> a + b),
        MINUS(1, "-", (a, b) -> a - b),
        MULTIPLY(2, "*", (a, b) -> a * b);

        private final int number;
        private final String symbol;
        private final BiFunction<Integer, Integer, Integer> function;

        Operation(int operationNumber, String operationSymbol,
                  BiFunction<Integer, Integer, Integer> operationFunction) {
            this.number = operationNumber;
            this.symbol = operationSymbol;
            this.function = operationFunction;
        }

        public static Operation getOperation(int operationNumber) {
            Optional<Operation> result = Arrays.stream(Operation.values())
                    .filter(o -> o.number == operationNumber)
                    .findFirst();

            if (result.isPresent()) {
                return result.get();
            } else {
                throw new UnsupportedOperationException(String.valueOf(operationNumber));
            }
        }
    }
}
