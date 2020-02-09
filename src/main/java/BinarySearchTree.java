package main.java;

//O (log n) cause were halfing shit

public class BinarySearchTree {

    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }

    }

    Node root;

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

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        //this effectively sets the root to null
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            //no child
            if (current.left == null && current.right == null) {
                return null;
            }

            //one child
            //return non null child so it can be assigned to the parent node
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            //two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    /*
    Traversals
     */

    /*
    Depth First -goes as deep as much as possible in every child before
    going to next sibling
     */

    //In-order
    //first visit the left sub tree, then the root node, then finally the right
    //sub tree

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    //Pre=order
    //visit root, then left, then right
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //Post-order
    //left, then right, then root
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    /*
    Breadth First - visit all nodes of a level before going to next level
    left to right, starting from root.

    For the implementation, we'll use a Queue to hold the nodes from each level in order.
    We'll extract each node from the list, print its values, then add its children to the queue:
     */

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }

}
