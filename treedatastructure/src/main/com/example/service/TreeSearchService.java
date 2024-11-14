package treedatastructure.src.main.com.example.service;

import treedatastructure.src.main.com.example.model.TreeNode;

import java.util.Optional;

// TreeSearchService.java
public class TreeSearchService {

    public Optional<Character> search(TreeNode node, int targetId) {
        // Base case: if the node is null, return an empty Optional
        if (node == null) {
            return Optional.empty();
        }

        // Use Optional chaining to find the character
        return Optional.of(node)
                .filter(n -> n.getId() == targetId)
                .map(TreeNode::getCharacter)
                .or(() -> search(node.getLeft(), targetId))
                .or(() -> search(node.getRight(), targetId));
    }
}

