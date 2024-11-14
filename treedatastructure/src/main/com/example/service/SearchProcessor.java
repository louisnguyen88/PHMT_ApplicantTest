package treedatastructure.src.main.com.example.service;


import treedatastructure.src.main.com.example.model.TreeModel;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchProcessor {
    private static final Logger logger = Logger.getLogger(SearchProcessor.class.getName());
    private final TreeSearchService searchService;
    private final TreeModel tree;

    public SearchProcessor(TreeModel tree, TreeSearchService searchService) {
        this.tree = tree;
        this.searchService = searchService;
    }

    public Optional<Character> search(int targetId) {
        try {
            return searchService.search(tree.getRoot(), targetId);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred during search", e);
            return Optional.empty();
        }
    }
}



