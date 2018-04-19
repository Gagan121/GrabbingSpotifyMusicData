package com.home.gs.Tree;


//generic node
public class Node<T extends Comparable<T>>{
    private Node left;
    private Node right;
    private T data;


    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }



    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


    public T getData() {
        return data;
    }






}
