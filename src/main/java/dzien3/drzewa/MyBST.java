package dzien3.drzewa;

import java.util.ArrayList;
import java.util.List;

public class MyBST {

    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public List<Node> preOrder() {
        List<Node> listaWezlow = new ArrayList<>();
        recursivePreOrder(root, listaWezlow);
        return listaWezlow;
    }

    private void recursivePreOrder(Node current, List<Node> alreadyVisited) {

        if (current.left != null) {
            recursivePreOrder(current.left, alreadyVisited); // Left sub-tree
        }

        alreadyVisited.add(current); // Node

        if (current.right != null) {
            recursivePreOrder(current.right, alreadyVisited); // Right sub-tree
        }

    }

    public int countLeaves() {
        List<Node> listaWezlow = new ArrayList<>();
        countLeafesPostOrder(root, listaWezlow);
        return listaWezlow.size();
    }

    private void countLeafesPostOrder(Node current, List<Node> alreadyVisited) {

        if (current.left != null) {
            countLeafesPostOrder(current.left, alreadyVisited); // Left sub-tree
        }

        if (current.right != null) {
            countLeafesPostOrder(current.right, alreadyVisited); // Right sub-tree
        }
        if (current.right == null && current.left == null) alreadyVisited.add(current);

    }
}
