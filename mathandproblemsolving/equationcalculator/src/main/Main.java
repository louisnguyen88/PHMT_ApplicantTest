package mathandproblemsolving.equationcalculator.src.main;


import mathandproblemsolving.equationcalculator.src.main.calculation.EquationCalculator;
import mathandproblemsolving.equationcalculator.src.main.calculation.Calculator;
import mathandproblemsolving.equationcalculator.src.main.exception.InvalidInputException;
import mathandproblemsolving.equationcalculator.src.main.output.EquationLogger;
import mathandproblemsolving.equationcalculator.src.main.output.Result;
import mathandproblemsolving.equationcalculator.src.main.utils.InputHandler;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new EquationCalculator();

        boolean continueRunning = true;

        while (continueRunning) {
            try {
                // Attempt to retrieve input
                Optional<double[]> valuesOpt = inputHandler.getInput();

                // Process calculation if input is present
                valuesOpt.ifPresent(values -> {
                    Result result = calculator.calculate(values);
                    System.out.println("Calculated Result: " + result.getValue());
                    EquationLogger.logEquation(result.getEquation());
                });

                // Exit if user chose to quit
                continueRunning = !inputHandler.shouldQuit();
            } catch (InvalidInputException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An unexpected error occurred: ", e);
            }
        }
        System.out.println("Exiting the program.");
    }
}

