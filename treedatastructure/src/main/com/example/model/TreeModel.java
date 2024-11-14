package treedatastructure.src.main.com.example.model;

// Tree.java
public class TreeModel {
    private final TreeNode root;

    public TreeModel() {
        this.root = buildTree();
    }

    public TreeNode getRoot() {
        return root;
    }

    // Constructs the tree structure based on the diagram
    private TreeNode buildTree() {
        TreeNode root = new TreeNode(1, 'R');

        TreeNode node4 = new TreeNode(4, 'G');
        TreeNode node8 = new TreeNode(8, 'Q');
        root.setLeft(node4);
        root.setRight(node8);

        node4.setLeft(new TreeNode(6, 'H'));
        node4.setRight(new TreeNode(10, 'E'));

        TreeNode node9 = new TreeNode(9, 'U');
        node8.setLeft(node9);

        TreeNode node2 = new TreeNode(2, 'F');
        root.setLeft(node2);

        TreeNode node5 = new TreeNode(5, 'Z');
        node2.setLeft(node5);
        node2.setRight(new TreeNode(7, 'P'));

        node5.setLeft(new TreeNode(3, 'X'));
        node2.getRight().setRight(new TreeNode(11, 'L'));

        node9.setLeft(new TreeNode(12, 'T'));
        node9.setRight(new TreeNode(13, 'D'));

        return root;
    }
}
