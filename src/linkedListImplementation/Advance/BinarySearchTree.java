package linkedListImplementation.Advance;

import java.util.Scanner;

/* =======================
   Tree Node
   ======================= */
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/* =======================
   BST Logic Class
   ======================= */
class BST {
    TreeNode root;
    int count = 0;

    // INSERT
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root, parent = null;
        while (current != null) {
            parent = current;
            if (data < current.data)
                current = current.left;
            else if (data > current.data)
                current = current.right;
            else
                return;
        }

        if (data < parent.data)
            parent.left = newNode;
        else
            parent.right = newNode;
    }

    // INORDER TRAVERSAL
    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // SEARCH
    public boolean search(int target, TreeNode node) {
        if (node == null) {
            System.out.println("Target not found. Traversed nodes: " + count);
            count = 0;
            return false;
        }

        count++;
        if (node.data == target) {
            System.out.println("Target found. Traversed nodes: " + count);
            count = 0;
            return true;
        }

        return target < node.data
                ? search(target, node.left)
                : search(target, node.right);
    }

    // HEIGHT
    public int height(TreeNode node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // DELETE
    public TreeNode delete(TreeNode node, int data) {
        if (node == null) return null;

        if (data < node.data)
            node.left = delete(node.left, data);
        else if (data > node.data)
            node.right = delete(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            TreeNode successor = minValue(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }
        return node;
    }

    // MIN & MAX
    public TreeNode minValue(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public TreeNode maxValue(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // ROTATIONS
    public TreeNode leftRotation(TreeNode x) {
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    public TreeNode rightRotation(TreeNode x) {
        TreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    public TreeNode leftRightRotation(TreeNode x) {
        x.left = leftRotation(x.left);
        return rightRotation(x);
    }

    public TreeNode rightLeftRotation(TreeNode x) {
        x.right = rightRotation(x.right);
        return leftRotation(x);
    }
}

/* =======================
   Handler Class (Switch Case)
   ======================= */
class BSTHandler {
    private final BST bst = new BST();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            menu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> insert();
                case 2 -> traverse();
                case 3 -> search();
                case 4 -> delete();
                case 5 -> height();
                case 6 -> rotateLeft();
                case 7 -> rotateRight();
                case 8 -> rotateLR();
                case 9 -> rotateRL();
                case 10 ->findMin();
                case 11 -> findMax();
                case 0 -> System.out.println("Program terminated.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private void menu() {
        System.out.println("""
                
                ===== BINARY SEARCH TREE =====
                1. Insert
                2. Inorder Traversal
                3. Search
                4. Delete
                5. Height
                6. Left Rotation
                7. Right Rotation
                8. Left-Right Rotation
                9. Right-Left Rotation
                10. findMin
                11. findMax
                0. Exit
                =================================
                """);
    }

    private void insert() {
        System.out.print("Enter value: ");
        bst.insert(sc.nextInt());
    }

    private void traverse() {
        System.out.print("Inorder: ");
        bst.inorder(bst.root);
        System.out.println();
    }

    private void search() {
        System.out.print("Enter target: ");
        bst.search(sc.nextInt(), bst.root);
    }

    private void delete() {
        System.out.print("Enter value to delete: ");
        bst.root = bst.delete(bst.root, sc.nextInt());
    }

    private void height() {
        System.out.println("Tree height: " + bst.height(bst.root));
    }

    private void rotateLeft() {
        bst.root = bst.leftRotation(bst.root);
        System.out.println("Left rotation applied.");
    }

    private void rotateRight() {
        bst.root = bst.rightRotation(bst.root);
        System.out.println("Right rotation applied.");
    }

    private void rotateLR() {
        bst.root = bst.leftRightRotation(bst.root);
        System.out.println("Left-Right rotation applied.");
    }

    private void rotateRL() {
        bst.root = bst.rightLeftRotation(bst.root);
        System.out.println("Right-Left rotation applied.");
    }

    private void findMin(){
        if(bst.root == null){
            System.out.println(" ! Tree is empty ! ");
            return;
        }
        System.out.println("Min element in the tree is : "+bst.minValue(bst.root));
    }
    private void findMax(){
        if(bst.root == null){
            System.out.println(" ! Tree is empty ! ");
            return;
        }
        System.out.println("Max element in the tree is : "+bst.maxValue(bst.root));
    }
}
/* =======================
   Main Class
   ======================= */
public class BinarySearchTree {
    public static void main(String[] args) {
        new BSTHandler().start();
    }
}
