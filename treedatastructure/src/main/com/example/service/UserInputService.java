package treedatastructure.src.main.com.example.service;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserInputService {
    private static final Logger logger = Logger.getLogger(UserInputService.class.getName());
    private final Scanner scanner;

    public UserInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional<Integer> getTargetId() {
        try {
            System.out.print("Enter the integer to search for (or -1 to exit): ");
            int targetId = scanner.nextInt();
            return Optional.of(targetId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Clear the invalid input from the scanner buffer
            return Optional.empty(); // Return an empty Optional to indicate invalid input
        }
    }
}


