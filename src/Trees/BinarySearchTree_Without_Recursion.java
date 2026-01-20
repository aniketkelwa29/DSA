package Trees;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    TreeNode root;


    public void insert(int data)
    {
        TreeNode newNode = new TreeNode(data);
        if (root == null)
        {
            root = newNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null)
        {
               parent  = current;
            if (data < current.data)
            {
                current = current.left;
            }
            else if (data > current.data)
            {
                current = current.right;
            }
            else{
                return;
            }

        }
        if ( data<parent.data)
        {
            parent.left = newNode;
        }
        else
        {
            parent.right = newNode;
        }
    }
    public void treeTraversal(TreeNode node)
    {
        if (node != null)
        {
            treeTraversal(node.left);
            System.out.println(node.data + " ");
            treeTraversal(node.right);
        }
    }
}
public class BinarySearchTree_Without_Recursion {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(20);
        bst.insert(6);
        bst.insert(4);
        bst.insert(8);
        bst.insert(23);
        bst.insert(16);
        bst.treeTraversal(bst.root);

    }
}
