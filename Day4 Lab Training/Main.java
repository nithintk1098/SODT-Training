// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Node{
    int data;
    Node leftChild;
    Node rightChild;
    
    public Node(int data){
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}

class binarySearchTree{
    Node root;
    public binarySearchTree(){
        root = null;
    }
    public binarySearchTree(int n){
        root = new Node(n);
    }
    public void insert(int n){
        root = insertRec(root, n);
    }
    public Node insertRec(Node root, int n){
        if(root == null){
            root = new Node(n);
            return root;
        }else if(n < root.data){
            root.leftChild = insertRec(root.leftChild,n);
        }else if(n > root.data){
            root.rightChild = insertRec(root.rightChild,n);
        }
        return root;
    }
    public void inOrder(){
        inOrderRec(root);
    }
    public void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.leftChild);
            System.out.print(root.data +" ");
            inOrderRec(root.rightChild);
        }
    }
    public void preOrder(){
        preOrderRec(root);
    }
    public void preOrderRec(Node root){
        if(root!=null){
            System.out.print(root.data + " ");
            preOrderRec(root.leftChild);
            preOrderRec(root.rightChild);
    
        }
    }
    public void postOrder(){
        postOrderRec(root);
    }
    public void postOrderRec(Node root){
        if(root!=null){
            postOrderRec(root.leftChild);
            postOrderRec(root.rightChild);
            System.out.print(root.data + " ");
        }
    }
    public void search(int n){
        searchRec(root,n);
    }
    public void searchRec(Node root, int n){
        if(root == null){
            System.out.print("Value does not exit in the binary tree");
        }
        else if(root.data == n){
            System.out.print("Value found");
        }else if(root.data > n){
            System.out.println("Searching through -> "+root.data);
            searchRec(root.leftChild,n);
        }else if(root.data < n){
            System.out.println("Searching through -> "+root.data);
            searchRec(root.rightChild,n);
        }
    }
    public void count(){
        int count = 0;
        System.out.println("Number of nodes are: "+ countRec(root));
    }
    public int countRec(Node root){
        if(root == null){
            return 0;
        }else{
            return 1+countRec(root.leftChild)+countRec(root.rightChild);
        }
    }
    public void sum(){
        System.out.println("Number of nodes are: "+ sumRec(root));
    }
    public int sumRec(Node root){
        if(root == null){
            return 0;
        }else{
            return root.data+sumRec(root.leftChild)+sumRec(root.rightChild);
        }
    }
    public void height(){
        System.out.println("Height of the tree: "+ heightRec(root));
    }
    public int heightRec(Node root){
        if (root == null){
            return 0;
        }else{
            int left = heightRec(root.leftChild);
            int right = heightRec(root.rightChild);
            return 1+Math.max(left,right);
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        binarySearchTree bst = new binarySearchTree();
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(25);
        bst.insert(35);
        bst.insert(45);
        System.out.print(" InOrder Traversal-> ");
        bst.inOrder();
        System.out.print("\nPreOrder Traversal-> ");
        bst.preOrder();
        System.out.print("\nPostOrder Traversal-> ");
        bst.postOrder();
        // System.out.println("root is "+ bst.root.data);
        // System.out.println("\nWhat element do you want to search? ");
        // int searchTerm;
        // searchTerm = sc.nextInt();
        // bst.search(searchTerm);
        System.out.println();
        bst.count();
        System.out.println();
        bst.sum();
        System.out.println();
        bst.height();
    }
    
}
