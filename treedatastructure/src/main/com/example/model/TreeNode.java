package treedatastructure.src.main.com.example.model;

// TreeNode.java
public class TreeNode {
    private final int id;
    private final char character;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, char character) {
        this.id = id;
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public char getCharacter() {
        return character;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
