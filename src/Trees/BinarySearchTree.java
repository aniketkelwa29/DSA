package Trees;
class Node0 {
    int data;
    Node0 left;
    Node0 right;

    Node0(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
     Node0 root ;
    public Node0 insert(Node0 node, int data) {
        if (node == null) {
            return new Node0(data);
        }
        if (data > node.data) {
            node.right = insert(node.right, data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        }
        return node;
    }

    public void treeTraversal(Node0 node) {
        if (node != null) {
            treeTraversal(node.left);
            System.out.print(node.data + " ");
            treeTraversal(node.right);
        }
    }
}
class BinarySearchTree {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.root = tree.insert(tree.root, 8);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 9);

        tree.treeTraversal(tree.root);
    }
}