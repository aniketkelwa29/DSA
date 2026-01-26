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

int count=0;
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
    public boolean search(int target,TreeNode root){


        if(root == null){
            System.out.println("Target not found on traversing "+count +" nodes." );
            return false;
        }

        if(root.data == target)
        {
            System.out.println("Target found on traversing "+count +" nodes." );
            System.out.println("Target found "+target);
            return true;
        }
        else if (root.data<target)
        {
            count++;
           return search(target,root.right);
        }
        else
        {
            count++;
            return search(target,root.left);
        }
    }
    public int hieghtMeasurment(TreeNode root){

        if(root == null)
        {
            return -1;
        }
       return Math.max(hieghtMeasurment(root.left),hieghtMeasurment(root.right))+1;
    }
    public void deletion(){
        if(root == null){
            System.out.println("No any element present at the root node: ");
            return;
        }
        if(root.left == null){

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
        bst.insert(19);
        bst.treeTraversal(bst.root);
        bst.search(16,bst.root);

        System.out.println("hieght of the tree is "+bst.hieghtMeasurment(bst.root));

    }
}