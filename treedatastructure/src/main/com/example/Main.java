package treedatastructure.src.main.com.example;


import treedatastructure.src.main.com.example.model.TreeModel;
import treedatastructure.src.main.com.example.service.OutputService;
import treedatastructure.src.main.com.example.service.SearchProcessor;
import treedatastructure.src.main.com.example.service.TreeSearchService;
import treedatastructure.src.main.com.example.service.UserInputService;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class Main {
    public static void main(String[] args) {
        TreeModel tree = new TreeModel();
        TreeSearchService searchService = new TreeSearchService();
        UserInputService userInputService = new UserInputService(new Scanner(System.in));
        SearchProcessor searchProcessor = new SearchProcessor(tree, searchService);
        OutputService outputService = new OutputService();

        AtomicBoolean continueSearching = new AtomicBoolean(true);

        while (continueSearching.get()) {
            Optional<Integer> targetIdOptional = userInputService.getTargetId();

            // Handle both the exit and search cases using ifPresentOrElse
            targetIdOptional.ifPresentOrElse(
                    targetId -> {
                        if (targetId == -1) {
                            outputService.displayExitMessage();
                            continueSearching.set(false);
                        } else {
                            Optional<Character> result = searchProcessor.search(targetId);
                            outputService.displayResult(result);
                        }
                    },
                    () -> System.out.println("Please try again with a valid input.")
            );
        }
    }
}


