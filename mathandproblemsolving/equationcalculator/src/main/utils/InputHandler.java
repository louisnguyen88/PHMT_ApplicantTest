package mathandproblemsolving.equationcalculator.src.main.utils;

import mathandproblemsolving.equationcalculator.src.main.exception.InvalidInputException;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputHandler {
    private static final int MAX_INPUT_SIZE = 100000;
    private boolean quit = false;

    public Optional<double[]> getInput() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter double values (up to 100,000) separated by spaces, or type 'q' to quit:");

        String inputLine = scanner.nextLine().trim();

        // Check if the user wants to quit
        if ("q".equalsIgnoreCase(inputLine)) {
            quit = true;
            return Optional.empty(); // Return empty Optional since no calculation is needed
        }

        // Parse and validate input using streams
        String[] inputs = inputLine.split(" ");
        if (inputs.length > MAX_INPUT_SIZE) {
            throw new InvalidInputException("Maximum input limit exceeded. Only up to 100,000 values allowed.");
        }

        try {
            double[] valuesArray = Stream.of(inputs)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            return Optional.of(valuesArray);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input. Please enter only numeric values.");
        }
    }

    public boolean shouldQuit() {
        return quit;
    }
}





