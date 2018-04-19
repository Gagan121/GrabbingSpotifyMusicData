package com.home.gs.Tree;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeEngine < T extends Comparable<T>> implements BinaryTreeInterface<T> {

    private Node node = new Node();

    public void settingNodes(T[] values) {
        //setting the root node
        node.setData(values[0]);
        //and all its children
        for (int i = 1; i < values.length; i++) {
            addNode(values[i]);
        }
    }


    public void addNode(T element) {
        Node newNode = new Node();
        newNode.setData(element);
        addRecursiveNode(node, newNode);

    }

    private void addRecursiveNode(Node node, Node newNode) {

        //check if left or right branch placement
        if (node.getData().compareTo(newNode.getData()) > 0) {
            //if null then add it as a node
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                return;
            }
            addRecursiveNode(node.getLeft(), newNode);
        } else if (node.getData().compareTo(newNode.getData()) < 0){

            if (node.getRight() == null) {
                node.setRight(newNode);
                return;
            }
            addRecursiveNode(node.getRight(), newNode);

        }


    }


    public List<T> getSortedTreeAsc() {
        List<Node> list = new ArrayList<>();

        findInSequenceRecursiveNodeSmallToLarge(false, node, list);

        return convertNodeBackToData(list);
    }


    private Node findInSequenceRecursiveNodeSmallToLarge(boolean reverse, Node node, List<Node> listNode) {

        //the reverse is if you want descending
        if (reverse) {
            //go all the way to the end of the very right end branch and add the node to the list
            if (node.getRight() != null) {
                //if yes then go deeper
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getRight(), listNode);
            }
            //if the next right is null then add to the list
            listNode.add(node);

            if (node.getLeft() != null) {
                //check for left children and recurse
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getLeft(), listNode);
            }

            return null;


        } else {
            //the opposite to the above
            if (node.getLeft() != null) {
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getLeft(), listNode);
            }

            listNode.add(node);

            if (node.getRight() != null) {
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getRight(), listNode);
            }

            return null;


        }

    }

    //uses the function above
    public List<T> getSortedTreeDesc() {
        List<Node> list = new ArrayList<>();

        //reversing variable is the boolean
        findInSequenceRecursiveNodeSmallToLarge(true, node, list);

        return convertNodeBackToData(list);

    }

    private List<T> convertNodeBackToData(List<Node> list){
        List<T> dataList = new ArrayList<>();
        for (Node node : list) {
            dataList.add((T)node.getData());
        }
        return dataList;
    }


}
