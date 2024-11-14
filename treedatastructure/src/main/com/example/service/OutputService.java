package treedatastructure.src.main.com.example.service;

import java.util.Optional;

public class OutputService {

    public void displayResult(Optional<Character> result) {
        result.ifPresentOrElse(
                character -> System.out.println("Character found: " + character),
                () -> System.out.println("Integer not found in any leaf node.")
        );
    }

    public void displayExitMessage() {
        System.out.println("Exiting the search program.");
    }
}

