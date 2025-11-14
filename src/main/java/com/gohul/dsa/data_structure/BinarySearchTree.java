package com.gohul.dsa.data_structure;

public class BinarySearchTree {

    private static class Node{
        int data;
        Node left;
        Node right;
        int height;
        Node(int data){
            this.data = data;
            left = right = null;
            height = 0;
        }
    }
    private Node root;

    public void preOrder(){
        preOrder(root);
    }
    public void inOrder(){
        inOrder(root);
    }
    public void postOrder(){
        postOrder(root);
    }
    public void add(int data){
        root = add(root, data);
    }
    public boolean search(int data){
        Node temp = search(root, data);
        return temp != null;
    }
    public void delete(int data) throws Exception {
        root = delete(root, data);
    }

    private int getHeight(Node node){
        if(node == null) return -1;
        return node.height;
    }

    private int findBalFactor(Node node){
        if(node == null) return 0;
        return 1 + getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node A){
        Node B = A.left;
        Node t2 = B.right;

        B.right = A;
        A.left = t2;

        A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
        B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));

        return B;

    }

    private Node leftRotate(Node A){
        Node B = A.right;
        Node t2 = B.left;

        B.left = A;
        A.right = t2;

        A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
        B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));


        return B;
    }

    private void preOrder(Node root){
        if(root == null) return;;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root){
        if(root == null) return;;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    private void postOrder(Node root){
        if(root == null) return;;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private Node add(Node root, int data){
        if (root == null) return new Node(data);

        if(root.data > data)
            root.left = add(root.left, data);
        else if(root.data < data)
            root.right = add(root.right, data);
        else return root;

//        int balFactor = findBalFactor(root);
//        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        int balance = findBalFactor(root);

        // LL
        if (balance > 1 && findBalFactor(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balance > 1 && findBalFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balance < -1 && findBalFactor(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balance < -1 && findBalFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }

    private Node search(Node root, int data){
        if(root == null) return null;

        if(root.data > data) return search(root.left, data);
        else if(root.data < data) return search(root.right, data);

        return root;
    }

    private Node delete(Node root, int data) throws Exception {
        if (root == null) throw new Exception("Given data:: " + data + " is not in the tree");
        if (root.data > data) root.left = delete(root.left, data);
        else if (root.data < data) root.right = delete(root.right, data);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = findMinFromRight(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    private int findMinFromRight(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }


}
