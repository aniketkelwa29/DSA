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
    public TreeNode deletion(TreeNode node,int data){
        if(node == null)
        {
            return null;
        }
        if(data<node.data)
        {
            node.left = deletion(node.left,data);
        }
        else if (data>node.data)
        {
            node.right = deletion(node.right,data);
        }

        else
        {
            if (node.left == null)
            {
                return node.right;
            }
            else if (node.right == null)
            {
                return node.left;
            }
            TreeNode successor = minValue(node.right);
            node.data = successor.data;
            node.right = deletion(node.right, successor.data);
        }
        return node;
    }

    public TreeNode minValue(TreeNode node)
    {
        TreeNode current = node;
        while(current.left!=null)
        {
            current = current.left;
        }
        return current;
    }

    public TreeNode maxValue(TreeNode node){
        TreeNode current = node;
        while(current.right!=null)
        {
            current = current.right;
        }
        return current;
    }

    public TreeNode LCA(TreeNode node,int n1,int n2)
    {
        if(node == null){
              return node;
        }
        if (node.data>n1 && node.data> n2 ) {
                return LCA(node.left,n1, n2 );
        }

        if (node.data <n1 && node.data <n2){
           return  LCA(node.right,n1,n2);
        }
        return node;

    }
    public TreeNode leftRotation(TreeNode x){
        TreeNode y = x.right;
         x.right = y.left  ;
         y.left =x;
        return y;
    }
    public TreeNode rightRotation(TreeNode x){
        TreeNode y= x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }
    public TreeNode rightLeftRotation(TreeNode x){
    x.right = rightRotation(x.right);
    return leftRotation(x);
    }
    public TreeNode leftRightRotation(TreeNode x){
        x.left = leftRotation(x.left);
        return rightRotation(x);
    }
}
public class BinarySearchTree_Without_Recursion
{
    public static void main(String[] args)
    {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(9);
        bst.treeTraversal(bst.root);
        bst.search(16,bst.root);
//        bst.deletion(bst.root,20);
        bst.treeTraversal(bst.root);
//        bst.root =   bst.leftRotation(bst.root);
//        bst.root = bst.rightRotation(bst.root);
//        bst.root = bst.rightLeftRotation(bst.root);
        bst.root = bst.leftRightRotation(bst.root);
        System.out.println("-----"+bst.root.data+"-----");
        System.out.println("-----"+bst.root.left.data+"-----");
        System.out.println("-----"+bst.root.right.data+"-----");
        System.out.println("maxValue in the tree is " +bst.maxValue(bst.root).data);
        System.out.println("minValue in the tree is "+bst.minValue(bst.root).data);
        System.out.println("hieght of the tree is "+bst.hieghtMeasurment(bst.root));
        System.out.println(bst.LCA(bst.root, 5,9).data);

    }
}