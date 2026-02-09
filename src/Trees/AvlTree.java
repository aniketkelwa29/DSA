package Trees;

class NNode {
    int data, hieght;
    NNode left, right;

    NNode(int data) {
        this.data = data;
        hieght = 1;
    }
}

class AvlTreeWorking {

    NNode root;

    int Hieght(NNode node) {
        if (node == null) return 0;

        return node.hieght;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }


    public NNode leftRotation(NNode x) {
        NNode y = x.right;
        x.right = y.left;
        y.left = x;

        x.hieght = max(Hieght(x.left), Hieght(x.right)) + 1;
        y.hieght = max(Hieght(y.left), Hieght(y.right)) + 1;

        return y;
    }

    public NNode rightRotation(NNode x) {
        NNode y = x.left;
        x.left = y.right;
        y.right = x;

        x.hieght = max(Hieght(x.left), Hieght(x.right)) + 1;
        y.hieght = max(Hieght(y.left), Hieght(y.right)) + 1;
        return y;
    }

    public NNode rightLeftRotation(NNode x) {
        x.right = rightRotation(x.right);
        return leftRotation(x);
    }

    public NNode leftRightRotation(NNode x) {
        x.left = leftRotation(x.left);
        return rightRotation(x);
    }

    int getBallance(NNode node) {
        if (node == null) return 0;
        return Hieght(node.left) - Hieght(node.right);
    }

    public NNode insert(NNode node, int data) {
        if (node == null) {
            return new NNode(data);
        }
        if (data > node.data) {
            node.right = insert(node.right, data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else
            return node;

        node.hieght = 1 + max(Hieght(node.left), Hieght(node.right));

        int balance = getBallance(node);

        if (balance > 1 && data < node.left.data) {
            return rightRotation(node);
        }

        if (balance < -1 && data > node.right.data) {
            return leftRotation(node);
        }

        if (balance > 1 && data > node.left.data) {
            return leftRightRotation(node);
        }

        if (balance < -1 && data < node.right.data) {
            return rightLeftRotation(node);
        }
        return node;
    }

    public void inOrder(NNode node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data + " ");
            inOrder(node.right);
        }
    }

}

public class AvlTree {
    public static void main(String args[]) {
        AvlTreeWorking tree = new AvlTreeWorking();
        NNode root = null;

        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 25);
        root = tree.insert(root, 35);

        System.out.println("Inorder traversal : ");
        tree.inOrder(root);
    }
}